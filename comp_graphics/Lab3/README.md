# Lab №3
#### **Topic:** Structure of .bmp files. Animation of primitives by means of means JavaFX libraries
#### **Objective:** 
1. studying the structure and features of using .bmp file;
2. studying standard JavaFX tools for image rendering;
3. studying the means of animation of primitives in JavaFX

### **Theoretical information:**
#### **Structure of an image file with .BMP extension**
BMP or Bitmap Picture is a bitmap file format
two-dimensional images, developed by Microsoft.
.bmp file consists of 3 parts: file header, BITMAP header and
the main part. Headers always have a fixed size, and the main part -
variable size, depending on the number of pixels in the image and the color gamut that is
is used. The main part consists of a color palette (may not be bits) and
the image itself. Let's consider the structure of the file with the extension .bmp

#### **Standard features for displaying images in JavaFX**
The JavaFX library has standard image rendering tools (Image Ops
APIs) currently working with .jpg, .bmp and .png images.
The main disadvantage at the moment is that monochrome, 16-bit and 256-bit .bmp
images can not be correctly displayed using standard functions
work with images.

The Image Ops API consists of the following key classes / interfaces in the package
javafx.scene.image:
- *Image* - the class used to load the image (synchronously or
asynchronously) located locally on a computer, or to download via
Url
- *ImageView* - the class used to visualize the image that was
loaded using the Image class.
- *WritableImage* - Class-Descendant Image. This class has a PixelWriter method for writing
pixels of the image. Class designers create either a blank image
the image of the specified size is ready to record in it information or
display the image transmitted using PixelReader.
- *PixelReader* - An interface that defines methods for obtaining data from pixels
image.
- *PixelWriter* - an interface that defines methods for recording pixel data
image.
- *PixelFormat* - an object that defines the data structure for pixels of this format.
- *WritablePixelFormat* - A PixelFormat object that represents the pixel format,
and saves all the colors and can therefore be used as the final format
to record arbitrary full-color images.

#### **Animation in JavaFX**
In JavaFX, the animation is represented by the javafx.animation class. Animation in JavaFX
is divided into temporal animations and object transitions (transformations).

Classes of standard transformations in JavaFX:
- *FadeTransition* - the effect of disappearance.
- *FillTransition* - image fill effect.
- *ParallelTransition* - playing several animations in parallel.
- *PathTransition* - create animation of motion along the trajectory.
- *PauseTransition* - Creates a pause when animation.
- *RotateTransition* - the turning effect.
- *ScaleTransition* - Scaling effect.
- *SequentialTransition* - Playing multiple animations sequentially.
- *StrokeTransition* - change the color of the figure.
- *TranslateTransition* - moving the object.

### Task options:
With the help of primitives, JavaFX can really represent the character for
option and execute its 2D animation. For animation use standard
JavaFX library tools.

![lab3_img2](https://user-images.githubusercontent.com/14183373/37541941-09d24728-2965-11e8-88d3-abc56247ccaf.png)

A compulsory implementation of the following types of animation is required:
1) moving;
2) turn;
3) scaling.

### Result:
![lab3_img1](https://user-images.githubusercontent.com/14183373/37541955-1ab5ea9a-2965-11e8-9281-be7e34fc2c1a.png)
