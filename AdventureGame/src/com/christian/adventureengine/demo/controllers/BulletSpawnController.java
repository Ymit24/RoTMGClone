package com.christian.adventureengine.demo.controllers;

import java.awt.event.KeyEvent;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.demo.data.Data;
import com.christian.adventureengine.input.Input;
import com.christian.adventureengine.logic.Controller;
import com.christian.adventureengine.rendering.Camera;

public class BulletSpawnController extends Controller {
	@Override
	public void Update(float deltaTime) {
		if (Input.GetKeyboardListener().isKeyDown(KeyEvent.VK_SPACE) ||
			Input.GetMouseListener().isMouseButtonDown(0)) {
			
			Vector2 mousePosition = Input.GetMouseListener().GetPosition();
			mousePosition = Camera.GetCamera().CalculateScreenToWorld(mousePosition);
			Vector2 playerPos = new Vector2(Data.world.GetPlayer().GetPosition());
			Vector2 direction = new Vector2(mousePosition.x - playerPos.x, mousePosition.y - playerPos.y).Normalized();
			
			Data.world.SpawnBullet(playerPos, direction);
		}
	}
}
