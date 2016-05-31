SuperStrict

Const WIDTH:Int = 1024
Const HEIGHT:Int = 768

' Draw 1000 
Function DrawLines()
	For Local x:Int = 0 To 1000
		SetColor Rand(0, 255), Rand(0, 255), Rand(0, 255)
		DrawLine Rand(2 * WIDTH) - (WIDTH / 2), Rand(2 * HEIGHT) - (HEIGHT / 2), Rand(2 * WIDTH) - (WIDTH / 2), Rand(2 * HEIGHT) - (HEIGHT / 2)
	Next
End Function

' Setup graphics
SetGraphicsDriver GLMax2DDriver()
Graphics WIDTH, HEIGHT, 0, 60, GRAPHICS_BACKBUFFER
SetBlend ALPHABLEND
glEnable GL_LINE_SMOOTH
For Local f:Int = 0 To 250
	SetClsColor 0, 0, 0
	Cls
	DrawLines()
	Flip
Next
