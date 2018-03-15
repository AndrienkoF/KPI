import com.sun.j3d.utils.universe.*;
import com.microcrowd.loader.java3d.max3ds.Loader3DS;

import java.awt.Color;
import javax.media.j3d.*;
import javax.media.j3d.Material;
import javax.vecmath.*;
import javax.media.j3d.Background;

import com.sun.j3d.loaders.*;
import com.sun.j3d.loaders.objectfile.ObjectFile;
import com.sun.j3d.loaders.lw3d.Lw3dLoader;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFrame;

public class Lab5 extends JFrame {
    static SimpleUniverse universe;
    static Scene scene;
    static Map<String, Shape3D> nameMap;
    static BranchGroup root;
    static Canvas3D canvas;

    static TransformGroup domino1;
    static TransformGroup domino2;
    static Transform3D transformDomino1;
    static Transform3D transformDomino2;



    public Lab5 () throws IOException{
        configureWindow();
        configureCanvas();
        configureUniverse();
        addModelToUniverse();
        setPlaneElementsList();
        addAppearance();
        addImageBackground();
        addLightToUniverse();
        addOtherLight();
        root.compile();
        universe.addBranchGraph(root);
    }

    private void configureWindow()  {
        setTitle("Lab5");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void configureCanvas(){
        canvas=new Canvas3D(SimpleUniverse.getPreferredConfiguration());
        canvas.setDoubleBufferEnable(true);
        getContentPane().add(canvas,BorderLayout.CENTER);
    }

    private void configureUniverse(){
        root= new BranchGroup();
        universe= new SimpleUniverse(canvas);
        universe.getViewingPlatform().setNominalViewingTransform();
    }

    private void addModelToUniverse() throws IOException{
        scene = getSceneFromFile("C://Fedia//Java//Lab5//Domino1.obj");
        // scene=getSceneFromLwoFile("d://3dModels//Aspen.lwo");
        root=scene.getSceneGroup();
    }

    private void addLightToUniverse(){
        Bounds bounds = new BoundingSphere();
        Color3f color = new Color3f(65/255f, 30/255f, 25/255f);
        Vector3f lightdirection = new Vector3f(-1f,-1f,-1f);
        DirectionalLight dirlight = new DirectionalLight(color,lightdirection);
        dirlight.setInfluencingBounds(bounds);
        root.addChild(dirlight);
    }

    private void printModelElementsList(Map<String,Shape3D> nameMap){
        for (String name : nameMap.keySet()) {
            System.out.printf("Name: %s\n", name);}
    }

    private void setPlaneElementsList() {
        nameMap=scene.getNamedObjects();
        printModelElementsList(nameMap); //Print elements of your model:

        // 1-st DOMINO -------------------------------------------

        domino1 = new TransformGroup();
        transformDomino1 = new Transform3D();
        transformDomino1.rotZ(300);
        Vector3f vectorDomino1 = new Vector3f(.5f, -0.3f, -0.2f);
        transformDomino1.setTranslation(vectorDomino1);


        domino1.setTransform(transformDomino1);
        //--------------------------------------------------------

        // 2-nd DOMINO -------------------------------------------
        domino2 = new TransformGroup();
        transformDomino2 = new Transform3D();
        transformDomino2.rotZ(300);
        Vector3f vectorDomino2 = new Vector3f(0.2f, -0.3f, -0.4f);
        transformDomino2.setTranslation(vectorDomino2);


        domino2.setTransform(transformDomino2);
        //--------------------------------------------------------

        root.removeChild(nameMap.get("cubo"));
        root.removeChild(nameMap.get("cubo.001"));
        root.removeChild(nameMap.get("cubo.002"));
        root.removeChild(nameMap.get("cubo.003"));
        root.removeChild(nameMap.get("cubo.004"));
        root.removeChild(nameMap.get("cube.028"));
        root.removeChild(nameMap.get("cube.027"));
        root.removeChild(nameMap.get("cube.026"));
        root.removeChild(nameMap.get("cube.025"));
        root.removeChild(nameMap.get("cube.024"));
        root.removeChild(nameMap.get("cube.023"));
        root.removeChild(nameMap.get("cube.022"));
        root.removeChild(nameMap.get("cube.021"));
        root.removeChild(nameMap.get("cube.020"));
        root.removeChild(nameMap.get("cube.019"));
        root.removeChild(nameMap.get("cube.018"));
        root.removeChild(nameMap.get("cube.017"));
        root.removeChild(nameMap.get("cube_016"));
        root.removeChild(nameMap.get("cube_015"));
        root.removeChild(nameMap.get("cube.014"));
        root.removeChild(nameMap.get("cube.013"));
        root.removeChild(nameMap.get("cube.012"));
        root.removeChild(nameMap.get("cube.011"));
        root.removeChild(nameMap.get("cube.010"));
        root.removeChild(nameMap.get("cube.009"));
        root.removeChild(nameMap.get("cube.008"));
        root.removeChild(nameMap.get("cube.007"));
        root.removeChild(nameMap.get("cube.006"));
        root.removeChild(nameMap.get("cube.005"));
        root.removeChild(nameMap.get("cube.004"));
        root.removeChild(nameMap.get("cube.003"));
        root.removeChild(nameMap.get("cube.002"));
        root.removeChild(nameMap.get("cube.001"));

        domino1.addChild(nameMap.get("cube_016"));
        domino2.addChild(nameMap.get("cube_015"));
        domino1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        domino2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        root.addChild(domino1);
        root.addChild(domino2);

    }

    Texture getTexture(String path) {
        TextureLoader textureLoader = new TextureLoader(path,"LUMINANCE",canvas);
        Texture texture = textureLoader.getTexture();
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor( new Color4f( 0.0f, 1.0f, 0.0f, 0.0f ) );
        return texture;
    }

    Material getMaterial() {
        Material material = new Material();
        material.setAmbientColor ( new Color3f( 0.33f, 0.0f, 0.23f ) );
        material.setDiffuseColor ( new Color3f( 0.50f, 0.0f, 0.00f ) );
        material.setSpecularColor( new Color3f( 0.95f, 0.0f, 0.00f ) );
        material.setShininess( 0.3f );
        material.setLightingEnable(true);
        return material;
    }

    private void addAppearance(){
        // DOMINO 1 ----------------------------------------------------------------
        Appearance planeAppearance = new Appearance();
        planeAppearance.setTexture(getTexture("C://Fedia//Java//Lab5//materialPink.jpg"));
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.COMBINE);
        planeAppearance.setTextureAttributes(texAttr);
        planeAppearance.setMaterial(getMaterial());
        Shape3D domi1 = nameMap.get("cube_016");
        domi1.setAppearance(planeAppearance);
        //--------------------------------------------------------------------------

        // DOMINO 2 ----------------------------------------------------------------
        Appearance planeAppearance2 = new Appearance();
        planeAppearance2.setTexture(getTexture("C://Fedia//Java//Lab5//wood2.jpg"));
        TextureAttributes texAttr2 = new TextureAttributes();
        texAttr2.setTextureMode(TextureAttributes.COMBINE);
        planeAppearance2.setTextureAttributes(texAttr2);
        planeAppearance2.setMaterial(getMaterial());
        Shape3D domi2 = nameMap.get("cube_015");
        domi2.setAppearance(planeAppearance2);

    }

    private void addImageBackground(){
        TextureLoader t = new TextureLoader("C://Fedia//Java//Lab5//fon2.jpg", canvas);
        Background background = new Background(t.getImage());
        background.setImageScaleMode(Background.SCALE_FIT_ALL);
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),100.0);
        background.setApplicationBounds(bounds);
        root.addChild(background);
    }

    private void addOtherLight(){
        Color3f directionalLightColor = new Color3f(Color.BLACK);
        Color3f ambientLightColor = new Color3f(Color.WHITE);
        Vector3f lightDirection = new Vector3f(-1F, -1F, -1F);

        AmbientLight ambientLight = new AmbientLight(ambientLightColor);
        DirectionalLight directionalLight = new DirectionalLight(directionalLightColor, lightDirection);

        Bounds influenceRegion = new BoundingSphere();

        ambientLight.setInfluencingBounds(influenceRegion);
        directionalLight.setInfluencingBounds(influenceRegion);
        root.addChild(ambientLight);
        root.addChild(directionalLight);
    }

    public static Scene getSceneFromFile(String location) throws IOException {
        ObjectFile file = new ObjectFile(ObjectFile.RESIZE);
        file.setFlags (ObjectFile.RESIZE | ObjectFile.TRIANGULATE | ObjectFile.STRIPIFY);
        return file.load(new FileReader(location));
    }


    public static void main(String[]args){
        try {
            Lab5 window = new Lab5();

            AnimationDomino planeMovement = new AnimationDomino(domino1, domino2, transformDomino1, transformDomino2, window);
            window.setVisible(true);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

