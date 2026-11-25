package net.xanthian.camera_keybinds;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.CameraType;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import com.mojang.blaze3d.platform.InputConstants;

public class CameraKeybinds implements ClientModInitializer {

	private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(
			Identifier.fromNamespaceAndPath("camera_keybinds", "camera_keybinds"));

	private static CameraType lastPerspective = CameraType.FIRST_PERSON;

	private static KeyMapping setPerspectiveFirstPerson;
	private static KeyMapping setPerspectiveThirdPerson;
	private static KeyMapping setPerspectiveThirdPersonReverse;

	private static KeyMapping switchPerspectiveFirstPersonAndLast;
	private static KeyMapping switchPerspectiveThirdPersonAndLast;
	private static KeyMapping switchPerspectiveThirdPersonReverseAndLast;

	private static KeyMapping holdPerspectiveFirstPerson;
	private static KeyMapping holdPerspectiveThirdPerson;
	private static KeyMapping holdPerspectiveThirdPersonReverse;

	private static boolean heldPerspectiveFirstPersion = false;
	private static boolean heldPerspectiveThirdPersion = false;
	private static boolean heldPerspectiveThirdPersionReverse = false;

	private boolean holdPerspective(Minecraft client, KeyMapping key, CameraType perspective, boolean keyHeld) {
		if(!keyHeld && key.isDown()) {
            lastPerspective = client.options.getCameraType();
			client.options.setCameraType(perspective);
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

	@Override
	public void onInitializeClient() {
		setPerspectiveFirstPerson = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.first_person_camera",
				InputConstants.KEY_I,
				CATEGORY
		));
		setPerspectiveThirdPerson = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.third_person_camera",
				InputConstants.KEY_O,
				CATEGORY
		));
		setPerspectiveThirdPersonReverse = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.third_person_reverse_camera",
				InputConstants.KEY_P,
				CATEGORY
		));
		switchPerspectiveFirstPersonAndLast = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.switch_first_person_camera",
				InputConstants.KEY_B,
				CATEGORY
		));
		switchPerspectiveThirdPersonAndLast = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.switch_third_person_camera",
				InputConstants.KEY_N,
				CATEGORY
		));
		switchPerspectiveThirdPersonReverseAndLast = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.switch_third_person_reverse_camera",
				InputConstants.KEY_M,
				CATEGORY
		));
		holdPerspectiveFirstPerson = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.hold_first_person_camera",
				InputConstants.KEY_J,
				CATEGORY
		));
		holdPerspectiveThirdPerson = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.hold_third_person_camera",
				InputConstants.KEY_K,
				CATEGORY
		));
		holdPerspectiveThirdPersonReverse = KeyMappingHelper.registerKeyMapping(new KeyMapping(
				"key.camera_keybinds.hold_third_person_reverse_camera",
				InputConstants.KEY_L,
				CATEGORY
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if(setPerspectiveFirstPerson.consumeClick()) {
				client.options.setCameraType(CameraType.FIRST_PERSON);
			}
			if(setPerspectiveThirdPerson.consumeClick()) {
				client.options.setCameraType(CameraType.THIRD_PERSON_BACK);
			}
			if(setPerspectiveThirdPersonReverse.consumeClick()) {
				client.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
			}

			if(switchPerspectiveFirstPersonAndLast.consumeClick()) {
			    CameraType perspective = client.options.getCameraType();
			    if (perspective != CameraType.FIRST_PERSON) {
					lastPerspective = perspective;
					client.options.setCameraType(CameraType.FIRST_PERSON);
				} else {
					client.options.setCameraType(lastPerspective);
				}
			}
			if(switchPerspectiveThirdPersonAndLast.consumeClick()) {
				CameraType perspective = client.options.getCameraType();
				if (perspective != CameraType.THIRD_PERSON_BACK) {
					lastPerspective = perspective;
					client.options.setCameraType(CameraType.THIRD_PERSON_BACK);
				} else {
					client.options.setCameraType(lastPerspective);
				}
			}
			if(switchPerspectiveThirdPersonReverseAndLast.consumeClick()) {
				CameraType perspective = client.options.getCameraType();
				if (perspective != CameraType.THIRD_PERSON_FRONT) {
					lastPerspective = perspective;
					client.options.setCameraType(CameraType.THIRD_PERSON_FRONT);
				} else {
					client.options.setCameraType(lastPerspective);
				}
			}
			heldPerspectiveFirstPersion = holdPerspective(client, holdPerspectiveFirstPerson, CameraType.FIRST_PERSON, heldPerspectiveFirstPersion);
			heldPerspectiveThirdPersion = holdPerspective(client, holdPerspectiveThirdPerson, CameraType.THIRD_PERSON_BACK, heldPerspectiveThirdPersion);
			heldPerspectiveThirdPersionReverse = holdPerspective(client, holdPerspectiveThirdPersonReverse, CameraType.THIRD_PERSON_FRONT, heldPerspectiveThirdPersionReverse);
		});
	}
}
