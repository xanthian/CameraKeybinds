package net.xanthian.camera_keybinds;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class Keybinding {

    public static final String setPerspectiveFirstPerson = "key.camera_keybinds.first_person_camera";
    public static final String setCameraCategory = "category.camera_keybinds.camera_keybinds";
    public static final String setPerspectiveThirdPerson = "key.camera_keybinds.third_person_camera";
    public static final String setPerspectiveThirdPersonReverse = "key.camera_keybinds.third_person_reverse_camera";
    public static final String switchPerspectiveFirstPersonAndLast = "key.camera_keybinds.switch_first_person_camera";
    public static final String switchPerspectiveThirdPersonAndLast = "key.camera_keybinds.switch_third_person_camera";
    public static final String switchPerspectiveThirdPersonReverseAndLast = "key.camera_keybinds.switch_third_person_reverse_camera";
    public static final String holdPerspectiveFirstPerson = "key.camera_keybinds.hold_first_person_camera";
    public static final String holdPerspectiveThirdPerson = "key.camera_keybinds.hold_third_person_camera";
    public static final String holdPerspectiveThirdPersonReverse = "key.camera_keybinds.hold_third_person_reverse_camera";

    public static final KeyMapping FIRST_PERSON = new KeyMapping(setPerspectiveFirstPerson, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_U, setCameraCategory);

    public static final KeyMapping THIRD_PERSON = new KeyMapping(setPerspectiveThirdPerson, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_I, setCameraCategory);

    public static final KeyMapping THIRD_PERSON_REVERSE = new KeyMapping(setPerspectiveThirdPersonReverse, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_O, setCameraCategory);

    public static final KeyMapping FIRST_PERSON_AND_LAST = new KeyMapping(switchPerspectiveFirstPersonAndLast, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_B, setCameraCategory);

    public static final KeyMapping THIRD_PERSON_AND_LAST = new KeyMapping(switchPerspectiveThirdPersonAndLast, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_N, setCameraCategory);

    public static final KeyMapping THIRD_PERSON_REVERSE_AND_LAST = new KeyMapping(switchPerspectiveThirdPersonReverseAndLast, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_M, setCameraCategory);

    public static final KeyMapping HOLD_FIRST_PERSON = new KeyMapping(holdPerspectiveFirstPerson, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, setCameraCategory);

    public static final KeyMapping HOLD_THIRD_PERSON = new KeyMapping(holdPerspectiveThirdPerson, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_J, setCameraCategory);

    public static final KeyMapping HOLD_THIRD_PERSON_REVERSE = new KeyMapping(holdPerspectiveThirdPersonReverse, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_K, setCameraCategory);

}