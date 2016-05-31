from OpenGL.GLUT import *
from OpenGL.GLU import *
from OpenGL.GL import *
import sys
import random

name = "2D OpenGL Vector Performance"

WIDTH = 1024
HEIGHT = 768
global frame


def main():
    glutInit(sys.argv)
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH)
    glutInitWindowSize(WIDTH, HEIGHT)
    glutCreateWindow(name)

    glClearColor(0.0, 0.0, 0.0, 1.0)
    glShadeModel(GL_SMOOTH)
    glEnable(GL_DEPTH_TEST)
    glutDisplayFunc(display)
    glMatrixMode(GL_PROJECTION)
    glLoadIdentity()
    glOrtho(0, WIDTH, 0, HEIGHT, -1, 1)
    glMatrixMode(GL_MODELVIEW)
    glutMainLoop()
    return


def display():
    global frame
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT)
    glLineWidth(1.0)
    glBegin(GL_LINES)
    for x in range(0, 1000):
        glColor3f(random.random(), random.random(), random.random())
        glVertex3f(random.randint(-WIDTH, WIDTH * 2), random.randint(-HEIGHT, HEIGHT * 2), 0.0)
        glVertex3f(random.randint(-WIDTH, WIDTH * 2), random.randint(-HEIGHT, HEIGHT * 2), 0.0)
    glEnd()
    glutSwapBuffers()
    frame = frame + 1
    if frame == 250:
        exit()
    glutPostRedisplay()
    return

if __name__ == '__main__':
    frame = 0
    main()
