extends Node

#Estado del control. Presionado o suelto
var estado = false

#Valores vertical y horizontal
var __h = 0
var __v = 0
var __ctrl
var __max
var __centro

func _ready():
	__ctrl = get_node("Control")
	__max = get_size() - __ctrl.get_size()
	__centro = __max/2
	set_process_input(true)

func _input(event):
	#Si se presiona el boton izquierdo del mouse
	if event.type == InputEvent.MOUSE_BUTTON && event.button_index == BUTTON_LEFT && event.is_pressed() == true && estado==false:
		#Si se presiona el Joystick procede al arrastre
		#Hay que corregir esta parte!!!!
		if event.pos > __ctrl.get_global_pos() && event.pos < __ctrl.get_global_pos() + __ctrl.get_size():
			estado = true
	
	#Si el boton izquierdo del mouse se suelta
	elif event.type == InputEvent.MOUSE_BUTTON && event.button_index == BUTTON_LEFT && event.is_pressed() == false && estado==true:
		#Resetea la posicion del Joystick al soltarlo
		__ctrl.set_pos(__centro)
		__h=0
		__v=0
		estado = false
	#Si se comienza el arrastre del Joystick
	elif event.type == InputEvent.MOUSE_MOTION && estado==true:
		#Obtiene la posicion centrada del Joystick dentro del Control 
		var pos = Vector2(get_local_mouse_pos() - (__ctrl.get_size()/2))

		#Rango de movimiento horizontal para el Joystick
		if pos.x>__max.x: pos.x = __max.x
		elif pos.x<0: pos.x = 0

		#Rango de movimiento vertical para el JoysticK
		if pos.y>__max.y: pos.y = __max.y
		elif pos.y<0: pos.y = 0
	
		#Arrastra el Joystick
		__ctrl.set_pos(pos)
		
		# Retorna valores entre -1 y 1 para vertical y horizontal
		# Se aplica regla de tres simplificada
		__h = (pos.x/__centro.x) - 1
		__v = (pos.y/__centro.y) - 1

func getHorizontal():
	return(__h)

func getVertical():
	return(__v)