/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakes;

/**
 *
 * @author Tomy
 */
abstract class AItem extends AObject {

    protected ItemType type;
    private Generator gen;

    public AItem() {
        this.gen = Generator.getInstance();
    }

    public ItemType getType() {
        return type;
    }
    
    public void locateItem(){
        this.position = gen.getRandCoordinate();
    }
    
//    //shallow copy (plytka kopia)
//    @Override
//    public AItem clone() throws CloneNotSupportedException{
//        return (AItem)super.clone();
//    }
    @Override
    protected abstract AItem clone();
    
//    @Override
//    public Object clone() throws CloneNotSupportedException {
//      Object clone = null;
//      
//      try {
//         clone = super.clone();
//         
//      } catch (CloneNotSupportedException e) {
//      }
//      
//      return clone;
//   }
    
}
