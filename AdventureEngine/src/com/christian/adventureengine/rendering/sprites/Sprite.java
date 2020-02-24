package com.christian.adventureengine.rendering.sprites;

import java.awt.image.BufferedImage;

import com.christian.adventureengine.data.Vector2;

// TODO: Consider splitting image into a Texture class for seperating world space and screen space rendering
public class Sprite {
	private String filename;
	public BufferedImage image;
	public Vector2 PixelsToWorld;
	
	public Sprite(String filename, BufferedImage image) {
		this.filename = filename;
		this.image = image;
	}
	
	public String GetFilename() {
		return filename;
	}
	
	public BufferedImage GetImage() {
		return image;
	}
}
