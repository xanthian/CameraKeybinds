package net.xanthian.camera_keybinds;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(Initialise.MOD_ID)
@Mod.EventBusSubscriber
public class Initialise {

    public static final String MOD_ID = "camerakeybinds";

    public Initialise() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}