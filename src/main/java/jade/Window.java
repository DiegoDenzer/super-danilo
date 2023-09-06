package jade;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Window {
    private int width, height;
    private String title;


    private static Window window = null;
    private long glfWindow;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title ="Super Danilo";
    }

    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }
        return Window.window;
    }

    public  void run() {
        System.out.println("Hello Super Danilo LWJGL" + Version.getVersion() + "!");
        init();
        loop();
    }

    public void init() {
        // Setup Error -> config error
        GLFWErrorCallback.createPrint(System.err).set();
        //Initialize GLFW -> Iniciar
        if(!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        // Configure -> Configuracao GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE);

        // create the window -> Criando a janela
        glfWindow = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
        if(glfWindow == NULL) {
            throw new IllegalStateException("Failed to create the window");
        }
        // make the OPENGL -> criar openGL
        glfwMakeContextCurrent(glfWindow);
        glfwSwapInterval(1);
        glfwShowWindow(glfWindow);
        GL.createCapabilities();
    }

    public void loop() {
        while (!glfwWindowShouldClose(glfWindow)) {
            // Events -> Eventos
            glfwPollEvents();
            glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfWindow);


        }
    }

}
