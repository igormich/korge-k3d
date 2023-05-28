package korlibs.korge3d

import korlibs.image.bitmap.Bitmap
import korlibs.image.color.Colors
import korlibs.image.color.RGBA
import korlibs.image.color.setToColor
import korlibs.math.geom.*

@Korge3DExperimental
data class Material3D(
	val emission: Light = LightColor(Colors.BLACK),
	val ambient: Light = LightColor(Colors.BLACK),
	val diffuse: Light = LightColor(Colors.BLACK),
	//val specular: Light = LightColor(RGBA.float(.5f, .5f, .5f, 1f)),
	val specular: Light = LightColor(Colors.BLACK),
	val shininess: Float = .5f,
	val indexOfRefraction: Float = 1f
) {
	@Korge3DExperimental
	open class Light(val kind: String)

	@Korge3DExperimental
	data class LightColor(val color: RGBA) : Light("color") {
		val colorVec = MVector4().setToColor(color)
	}

	@Korge3DExperimental
	data class LightTexture(val bitmap: Bitmap?) : Light("texture") {
	}

	val kind: String = "${emission.kind}_${ambient.kind}_${diffuse.kind}_${specular.kind}"
}

val MVector4.immutable: Vector4 get() = Vector4(x, y, z, w)
