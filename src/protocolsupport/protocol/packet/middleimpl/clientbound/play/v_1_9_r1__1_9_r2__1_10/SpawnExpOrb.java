package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_1_9_r1__1_9_r2__1_10;

import java.io.IOException;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.packet.ClientBoundPacket;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleSpawnExpOrb;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.utils.recyclable.RecyclableCollection;
import protocolsupport.utils.recyclable.RecyclableSingletonList;

public class SpawnExpOrb extends MiddleSpawnExpOrb<RecyclableCollection<ClientBoundPacketData>> {

	@Override
	public RecyclableCollection<ClientBoundPacketData> toData(ProtocolVersion version) throws IOException {
		ClientBoundPacketData serializer = ClientBoundPacketData.create(ClientBoundPacket.PLAY_SPAWN_EXP_ORB_ID, version);
		serializer.writeVarInt(entityId);
		serializer.writeDouble(x);
		serializer.writeDouble(y);
		serializer.writeDouble(z);
		serializer.writeShort(count);
		return RecyclableSingletonList.create(serializer);
	}

}