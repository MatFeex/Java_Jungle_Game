/*
    // Classe permettant les animation du JComponent appellé //

    Le JComponent est mis en mouvement d'une certaine direction à une autre dans la direction souhaitée 
    La vitesse de deplacement est modifiable
    (directions,direction et vitesse entrés en argument)

 */
package animation;


import javax.swing.JComponent;


/**
 * @author mathieu
 */
public class Animation {
    public static void moveComponentToPosition(final String direction,final int start, final int end, final long delay, final int speed, final JComponent component) {
        (new Thread() {
            public void run() {
                if (direction == "right"){  //execute cette portion de code si le deplacement souhaité est vers la droite
                    for(int i = start; i <= end; i += speed) {
                        try {
                            Thread.sleep(delay);  // taux de raffraichissement du Thread
                            component.setLocation(i, component.getY());  // mise à jour de la position du Jcomponent
                        } catch (InterruptedException error) {
                        error.printStackTrace();   // print du probleme dans la console en cas d'erreur
                        }
                    }
                }
                else { // si le deplacement souhaité est vers la gauche
                    for(int i = start; i >= end; i -= speed) {
                    try {
                        Thread.sleep(delay);
                        component.setLocation(i, component.getY());
                    } catch (InterruptedException error) {
                        error.printStackTrace();
                    }
                }
                }
            }
        }).start();
    }
}
