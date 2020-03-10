package com.christian.adventuregame.demo.views;

import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.Sprites;
import com.christian.adventuregame.demo.data.Inventory;
import com.christian.adventuregame.demo.data.State;
import com.christian.adventuregame.demo.data.archetypes.ItemType;
import com.christian.adventuregame.demo.ui.elements.InventorySlot;

public class InventoryView extends View {
    public InventoryView() {
        super(11);
    }

    @Override
    public void draw(IRenderer renderer) {
        // TODO: Use callbacks when the inventory changes in order
        //       to not need to keep regrabbing sprites every frame.

        Inventory inventory = State.world.player.inventory;
        for (int i = 0; i < inventory.storageItems.length; i++) {
            ItemType item = inventory.storageItems[i];

            if (State.isDragging && item != null && i == State.slotIdDragging)
            {
                ((InventorySlot) State.mainUILayout.FindElementById("inventorySlot" + i)).SetIcon(null);
            }
            else {
                ((InventorySlot) State.mainUILayout.FindElementById("inventorySlot" + i)).SetIcon(item != null ? Sprites.GetSpriteManager().GetSprite(item.iconTextureFilename) : null);
            }
        }

        if (State.isDragging) {
            renderer.DrawScreenSprite(State.iconDragSprite, State.dragPosition);
        }
    }
}
