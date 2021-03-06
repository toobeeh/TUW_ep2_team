import java.util.Iterator;

/**
 * Octree data structure which is used to implement the barnes-hut algorithm in a 3d space
 */
public class CelestialOctree implements Iterable<Body> {

    private CelestialOctreeNode rootSector = null;
    private double rootSectorSize;

    public CelestialOctree(double rootSectorSize){
        this.rootSectorSize = rootSectorSize;
    }

    /**
     * adds a body to this octree
     * @param body body to add
     */
    public void addBody(Body body){

        // if octree is yet empty, init new node
        if(this.rootSector == null) {
            this.rootSector = new CelestialOctreeNode(
                    body,
                    this.rootSectorSize,
                    new Vector3(0,0,0)
            );
        }

        // else add body to root node
        else this.rootSector.addBody(body);
    }

    public Vector3 forceOn(Body body){
        if(this.rootSector == null) throw new Error("Tree has no bodies");
        return this.rootSector.forceOn(body);
    }

    public Iterator<Body> iterator() {

        if(this.rootSector == null) throw new Error("Tree has no bodies");
        return this.rootSector.iterator();
    }


}
