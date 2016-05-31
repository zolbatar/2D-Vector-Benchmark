import sys
import ctypes
import random
import sdl2
import sdl2.ext

name = "2D SDL Vector Performance"

WIDTH = 1024
HEIGHT = 768
global frame


def main():
    global frame

    sdl2.ext.init()
    window = sdl2.ext.Window("Hello World!", size=(WIDTH, HEIGHT))
    window.show()
    renderer = sdl2.ext.Renderer(window, -1, sdl2.SDL_RENDERER_ACCELERATED)
    running = True
    while running:
        frame = frame + 1
        if frame == 250:
            running = False
            break
        events = sdl2.ext.get_events()
        for event in events:
            if event.type == sdl2.SDL_QUIT:
                running = False
                break
        renderer.clear(sdl2.ext.Color(0, 0, 0))
        for x in range(0, 1000):
            colour = sdl2.ext.Color(random.randint(0, 255), random.randint(0, 255), random.randint(0, 255))
            renderer.draw_line(
                (random.randint(-WIDTH, WIDTH * 2), random.randint(-HEIGHT, HEIGHT * 2),
                 random.randint(-WIDTH, WIDTH * 2), random.randint(-HEIGHT, HEIGHT * 2)), colour)
        renderer.present()
    sdl2.ext.quit()
    return 0

if __name__ == '__main__':
    frame = 0
    main()
