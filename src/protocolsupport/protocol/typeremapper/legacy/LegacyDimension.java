package protocolsupport.protocol.typeremapper.legacy;

import java.text.MessageFormat;

import javax.annotation.Nonnull;

import protocolsupport.protocol.types.nbt.NBTCompound;

public class LegacyDimension {

	private LegacyDimension() {
	}

	public static @Nonnull String getStringId(@Nonnull NBTCompound dimension) {
		return dimension.getStringTagValueOrThrow("effects");
	}

	public static int getIntId(@Nonnull NBTCompound dimension) {
		switch (dimension.getStringTagValueOrThrow("effects")) {
			case "overworld":
			case "minecraft:overworld": {
				return 0;
			}
			case "the_nether":
			case "minecraft:the_nether": {
				return -1;
			}
			case "the_end":
			case "minecraft:the_end": {
				return 1;
			}
			default: {
				throw new IllegalArgumentException(MessageFormat.format("Unknown dimension {0}", dimension));
			}
		}
	}

	public static boolean hasSkyLight(int dimensionId) {
		return dimensionId == 0;
	}

	public static int getAlternativeIntId(int dimensionId) {
		return dimensionId != 0 ? 0 : -1;
	}

	public static @Nonnull String getWorldType(boolean flat) {
		return flat ? "flat" : "default";
	}

	public static @Nonnull String getLegacyResource(String resource) {
		if (resource.isEmpty()) {
			return resource;
		}
		return resource.charAt(0) == '#' ? resource.substring(1) : resource;
	}

}
