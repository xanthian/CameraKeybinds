package net.xanthian.camera_keybinds;

import net.minecraft.client.CameraType;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Options;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    private static CameraType lastPerspective = CameraType.FIRST_PERSON;

    private static boolean heldPerspectiveFirstPersion = false;
    private static boolean heldPerspectiveThirdPersion = false;
    private static boolean heldPerspectiveThirdPersionReverse = false;

    private static boolean holdPerspective(Minecraft client, KeyMapping key, CameraType cameraType, boolean keyHeld) {
        if(!keyHeld && key.isDown()) {
            lastPerspective = client.options.getCameraType();
            client.options.setCameraType(cameraType);
            keyHeld = true;
        }
        if(keyHeld && !key.isDown()) {
            CameraType currentPerspective = client.options.getCameraType();
            client.options.setCameraType(lastPerspective);
            lastPerspective = currentPerspective;
            keyHeld = false;
        }
        return keyHeld;
    }

    @Mod.EventBusSubscriber(modid = Initialise.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            Options options = Minecraft.getInstance().options;
            if (Keybinding.FIRST_PERSON.consumeClick()) {
                options.setCameraType(CameraType.FIRST_PERSON);
            }
            if (Keybinding.THIRD_PERSON.consumeClick()) {
                options.setCameraType(CameraType.THIRD_PERSON_BACK);
            }
            if (Keybinding.THIRD_PERSON_REVERSE.consumeClick()) {
                options.setCameraType(CameraType.THIRD_PERSON_FRONT);
            }

            if(Keybinding.FIRST_PERSON_AND_LAST.consumeClick()) {
                CameraType cameraType = options.getCameraType();
                if (cameraType != CameraType.FIRST_PERSON) {
                    lastPerspective = cameraType;
                    options.setCameraType(CameraType.FIRST_PERSON);
                } else {
                    options.setCameraType(lastPerspective);
                }
            }

            if(Keybinding.THIRD_PERSON_AND_LAST.consumeClick()) {
                CameraType cameraType = options.getCameraType();
                if (cameraType != CameraType.THIRD_PERSON_BACK) {
                    lastPerspective = cameraType;
                    options.setCameraType(CameraType.THIRD_PERSON_BACK);
                } else {
                    options.setCameraType(lastPerspective);
                }
            }

            if(Keybinding.THIRD_PERSON_REVERSE_AND_LAST.consumeClick()) {
                CameraType cameraType = options.getCameraType();
                if (cameraType != CameraType.THIRD_PERSON_FRONT) {
                    lastPerspective = cameraType;
                    options.setCameraType(CameraType.THIRD_PERSON_FRONT);
                } else {
                    options.setCameraType(lastPerspective);
                }
            }
            heldPerspectiveFirstPersion = holdPerspective(Minecraft.getInstance(), Keybinding.HOLD_FIRST_PERSON, CameraType.FIRST_PERSON, heldPerspectiveFirstPersion);
            heldPerspectiveThirdPersion = holdPerspective(Minecraft.getInstance(), Keybinding.HOLD_THIRD_PERSON, CameraType.THIRD_PERSON_BACK, heldPerspectiveThirdPersion);
            heldPerspectiveThirdPersionReverse = holdPerspective(Minecraft.getInstance(), Keybinding.HOLD_THIRD_PERSON_REVERSE, CameraType.THIRD_PERSON_FRONT, heldPerspectiveThirdPersionReverse);
        }
    }
    @Mod.EventBusSubscriber(modid = Initialise.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {

            event.register(Keybinding.FIRST_PERSON);
            event.register(Keybinding.FIRST_PERSON_AND_LAST);
            event.register(Keybinding.HOLD_FIRST_PERSON);
            event.register(Keybinding.THIRD_PERSON);
            event.register(Keybinding.THIRD_PERSON_AND_LAST);
            event.register(Keybinding.THIRD_PERSON_REVERSE);
            event.register(Keybinding.THIRD_PERSON_REVERSE_AND_LAST);
            event.register(Keybinding.HOLD_THIRD_PERSON);
            event.register(Keybinding.HOLD_THIRD_PERSON_REVERSE);
        }
    }
}
