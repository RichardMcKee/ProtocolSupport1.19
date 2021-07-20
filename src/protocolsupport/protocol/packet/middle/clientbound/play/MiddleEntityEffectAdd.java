package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.codec.VarNumberCodec;
import protocolsupport.protocol.packet.middle.CancelMiddlePacketException;
import protocolsupport.protocol.typeremapper.basic.GenericIdSkipper;
import protocolsupport.protocol.typeremapper.utils.SkippingTable.ArrayBasedIntSkippingTable;

public abstract class MiddleEntityEffectAdd extends MiddleEntityData {

	protected MiddleEntityEffectAdd(MiddlePacketInit init) {
		super(init);
	}

	protected final ArrayBasedIntSkippingTable effectSkipTable = GenericIdSkipper.EFFECT.getTable(version);

	protected int effectId;
	protected int amplifier;
	protected int duration;
	protected int flags;

	@Override
	protected void decodeData(ByteBuf serverdata) {
		effectId = serverdata.readByte();
		amplifier = serverdata.readByte();
		duration = VarNumberCodec.readVarInt(serverdata);
		flags = serverdata.readByte();
	}

	@Override
	protected void decodeDataLast(ByteBuf serverdata) {
		if (effectSkipTable.isSet(effectId)) {
			throw CancelMiddlePacketException.INSTANCE;
		}
	}

}
