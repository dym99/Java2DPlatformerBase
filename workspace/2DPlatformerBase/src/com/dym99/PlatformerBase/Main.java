package com.dym99.PlatformerBase;

import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.system.MemoryUtil;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
	
	private static GLFWErrorCallback errorCallback;
	private static long window;
	
	public static void main(String args[]) {
		errorCallback = Callbacks.errorCallbackPrint(System.err);
		glfwSetErrorCallback(errorCallback);
		
		if (glfwInit() == GL_FALSE) {
			throw new IllegalStateException("GLFW INIT FAILED!");
		}
		
		glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);
		
		window = glfwCreateWindow(1280, 720, "Game", MemoryUtil.NULL, MemoryUtil.NULL);

		if (window == MemoryUtil.NULL) {
			throw new IllegalStateException("WINDOW CREATION FAILED!");
		}
		
		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		glfwShowWindow(window);
		
		GLContext.createFromCurrent();
		
		while (glfwWindowShouldClose(window) == GL_FALSE) {
			glfwPollEvents();
			glClear(GL_COLOR_BUFFER_BIT);
			
			
			
			glfwSwapBuffers(window);
		}
	}

}
	