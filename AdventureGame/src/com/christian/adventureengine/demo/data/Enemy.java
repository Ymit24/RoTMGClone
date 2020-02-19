package com.christian.adventureengine.demo.data;

import com.christian.adventureengine.data.Vector2;

public class Enemy extends WorldObject {
	private float health;
	
	public Enemy(Vector2 position) {
		super(position);
	}
	
	public float GetHealth() {
		return health;
	}
	
	public void SetHealth(float health) {
		this.health = health;
	}
}
