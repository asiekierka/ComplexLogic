package me.matrix89.complexlogic;

import net.minecraft.util.EnumFacing;

public class XorLogic extends BundledGateLogic {
    @Override
    public Connection getType(EnumFacing dir) {
        switch (dir) {
            case NORTH:
                return Connection.OUTPUT_BUNDLED;
            case EAST:
            case WEST:
                return Connection.INPUT_BUNDLED;
            default:
                return Connection.NONE;
        }
    }

    @Override
    public byte[] calculateBundledOutput(EnumFacing facing) {
        int a = bundledRsToDigi(getInputValueBundled(EnumFacing.WEST));
        int b = bundledRsToDigi(getInputValueBundled(EnumFacing.EAST));
        return bundledDigiToRs(a ^ b);
    }

    @Override
    public State getLayerState(int i) {
        return State.ON;
    }

    @Override
    public State getTorchState(int i) {
        return State.ON;
    }
}
