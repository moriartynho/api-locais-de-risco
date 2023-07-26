package com.moriartynho.apilocaisderisco.mantimentos.services;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moriartynho.apilocaisderisco.imagem.Imagem;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;

	public void salvarImagem(Imagem imagem) throws IOException {
		imagemRepository.save(imagem);
	}

	public Imagem dadosToImagem(MultipartFile file) throws Exception {
		byte[] dados = compactarImagem(file.getInputStream());

		Imagem imagem = new Imagem();
		imagem.setDados(dados);
		return imagem;
	}
	
	
	public byte[] compactarImagem(InputStream inputStream) throws Exception {
	    BufferedImage imagemOriginal = ImageIO.read(inputStream);
	    
	    BufferedImage imagemCompactada = new BufferedImage(imagemOriginal.getWidth(), imagemOriginal.getHeight(), BufferedImage.TYPE_INT_RGB);
	    
	    Graphics2D g2d = imagemCompactada.createGraphics();
	    g2d.drawImage(imagemOriginal, 0, 0, null);
	    g2d.dispose();
	    
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    
	    ImageIO.write(imagemCompactada, "jpeg", outputStream);
	    
	    return outputStream.toByteArray();
	} 
	
	

}
