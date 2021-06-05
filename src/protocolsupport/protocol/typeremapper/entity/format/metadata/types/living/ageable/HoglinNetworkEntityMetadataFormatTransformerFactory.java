package protocolsupport.protocol.typeremapper.entity.format.metadata.types.living.ageable;

import protocolsupport.protocol.typeremapper.entity.format.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.format.metadata.types.base.AgeableNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class HoglinNetworkEntityMetadataFormatTransformerFactory extends AgeableNetworkEntityMetadataFormatTransformerFactory {

	public static final HoglinNetworkEntityMetadataFormatTransformerFactory INSTANCE = new HoglinNetworkEntityMetadataFormatTransformerFactory();

	protected HoglinNetworkEntityMetadataFormatTransformerFactory() {
		add(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Hoglin.ZOMBIFICATION_IMMUNITY, 16), ProtocolVersionsHelper.UP_1_16);
	}

}