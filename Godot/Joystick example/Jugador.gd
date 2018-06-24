extends Spatial

func _ready():

	set_physics_process(true)

func _physics_process(delta):
	var h = get_parent().get_node("Capa/Joystick").getHorizontal()
	var v = get_parent().get_node("Capa/Joystick").getVertical()
	
	get_child(0).translate(Vector3(-v,0,h))
