package com.christian.adventuregame.demo.data.terrain;

import com.christian.adventureengine.data.ISerializable;
import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.data.WorldObject;
import com.christian.adventureengine.utils.Deserializer;
import com.christian.adventureengine.utils.Serializer;

public class Tile extends WorldObject implements ISerializable {
	public String type;
	public String regionId;
	public String terrainFeatureId;

	public Tile(Vector2 position, String type, String regionId, String terrainFeatureId) {
		super(position);
		this.type = type;
		this.regionId = regionId;
		this.terrainFeatureId = terrainFeatureId;
	}
	
	private Tile(WorldObject object) {
		super(object.Position, object.Size);
	}

	@Override
	public void Serialize(Serializer serializer) {
		super.Serialize(serializer);
		serializer.WriteString(type);
		serializer.WriteString(regionId);
		serializer.WriteString(terrainFeatureId);
	}

	public static Tile Deserialize(Deserializer deserializer) {
		Tile tile = new Tile(WorldObject.Deserialize(deserializer));
		tile.type = deserializer.ReadString();
		tile.regionId = deserializer.ReadString();
		tile.terrainFeatureId = deserializer.ReadString();
		return tile;
	}
}
