package net.xanthian.camera_keybinds;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class CameraKeybinds implements ClientModInitializer {

	private static final KeyBinding.Category CATEGORY = KeyBinding.Category.create(
			Identifier.of("camera_keybinds", "camera_keybinds"));

	private static Perspective lastPerspective = Perspective.FIRST_PERSON;

	private static KeyBinding setPerspectiveFirstPerson;
	private static KeyBinding setPerspectiveThirdPerson;
	private static KeyBinding setPerspectiveThirdPersonReverse;

	private static KeyBinding switchPerspectiveFirstPersonAndLast;
	private static KeyBinding switchPerspectiveThirdPersonAndLast;
	private static KeyBinding switchPerspectiveThirdPersonReverseAndLast;

	private static KeyBinding holdPerspectiveFirstPerson;
	private static KeyBinding holdPerspectiveThirdPerson;
	private static KeyBinding holdPerspectiveThirdPersonReverse;

	private static boolean heldPerspectiveFirstPersion = false;
	private static boolean heldPerspectiveThirdPersion = false;
	private static boolean heldPerspectiveThirdPersionReverse = false;

	private boolean holdPerspective(MinecraftClient client, KeyBinding key, Perspective perspective, boolean keyHeld) {
		if(!keyHeld && key.isPressed()) {
            lastPerspective = client.options.getPerspective();
			client.options.setPerspective(perspective);
			keyHeld = true;
		}
		if(keyHeld && !key.isPressed()) {
			Perspective currentPerspective = client.options.getPerspective();
			client.options.setPerspective(lastPerspective);
			lastPerspective = currentPerspective;
			keyHeld = false;
		}
		return keyHeld;
	}

	@Override
	public void onInitializeClient() {
		setPerspectiveFirstPerson = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.first_person_camera",
				GLFW.GLFW_KEY_I,
				CATEGORY
		));
		setPerspectiveThirdPerson = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.third_person_camera",
				GLFW.GLFW_KEY_O,
				CATEGORY
		));
		setPerspectiveThirdPersonReverse = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.third_person_reverse_camera",
				GLFW.GLFW_KEY_P,
				CATEGORY
		));
		switchPerspectiveFirstPersonAndLast = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.switch_first_person_camera",
				GLFW.GLFW_KEY_B,
				CATEGORY
		));
		switchPerspectiveThirdPersonAndLast = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.switch_third_person_camera",
				GLFW.GLFW_KEY_N,
				CATEGORY
		));
		switchPerspectiveThirdPersonReverseAndLast = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.switch_third_person_reverse_camera",
				GLFW.GLFW_KEY_M,
				CATEGORY
		));
		holdPerspectiveFirstPerson = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.hold_first_person_camera",
				GLFW.GLFW_KEY_J,
				CATEGORY
		));
		holdPerspectiveThirdPerson = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.hold_third_person_camera",
				GLFW.GLFW_KEY_K,
				CATEGORY
		));
		holdPerspectiveThirdPersonReverse = KeyBindingHelper.registerKeyBinding(new KeyBinding(
				"key.camera_keybinds.hold_third_person_reverse_camera",
				GLFW.GLFW_KEY_L,
				CATEGORY
		));

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			if(setPerspectiveFirstPerson.wasPressed()) {
				client.options.setPerspective(Perspective.FIRST_PERSON);
			}
			if(setPerspectiveThirdPerson.wasPressed()) {
				client.options.setPerspective(Perspective.THIRD_PERSON_BACK);
			}
			if(setPerspectiveThirdPersonReverse.wasPressed()) {
				client.options.setPerspective(Perspective.THIRD_PERSON_FRONT);
			}

			if(switchPerspectiveFirstPersonAndLast.wasPressed()) {
			    Perspective perspective = client.options.getPerspective();
			    if (perspective != Perspective.FIRST_PERSON) {
					lastPerspective = perspective;
					client.options.setPerspective(Perspective.FIRST_PERSON);
				} else {
					client.options.setPerspective(lastPerspective);
				}
			}
			if(switchPerspectiveThirdPersonAndLast.wasPressed()) {
				Perspective perspective = client.options.getPerspective();
				if (perspective != Perspective.THIRD_PERSON_BACK) {
					lastPerspective = perspective;
					client.options.setPerspective(Perspective.THIRD_PERSON_BACK);
				} else {
					client.options.setPerspective(lastPerspective);
				}
			}
			if(switchPerspectiveThirdPersonReverseAndLast.wasPressed()) {
				Perspective perspective = client.options.getPerspective();
				if (perspective != Perspective.THIRD_PERSON_FRONT) {
					lastPerspective = perspective;
					client.options.setPerspective(Perspective.THIRD_PERSON_FRONT);
				} else {
					client.options.setPerspective(lastPerspective);
				}
			}
			heldPerspectiveFirstPersion = holdPerspective(client, holdPerspectiveFirstPerson, Perspective.FIRST_PERSON, heldPerspectiveFirstPersion);
			heldPerspectiveThirdPersion = holdPerspective(client, holdPerspectiveThirdPerson, Perspective.THIRD_PERSON_BACK, heldPerspectiveThirdPersion);
			heldPerspectiveThirdPersionReverse = holdPerspective(client, holdPerspectiveThirdPersonReverse, Perspective.THIRD_PERSON_FRONT, heldPerspectiveThirdPersionReverse);
		});
	}
}
