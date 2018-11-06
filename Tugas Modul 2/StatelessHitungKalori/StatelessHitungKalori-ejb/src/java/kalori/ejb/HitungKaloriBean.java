/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalori.ejb;

import javax.ejb.Stateless;

/**
 *
 * @author User ID
 */
@Stateless
public class HitungKaloriBean implements HitungKaloriBeanLocal {

    
    //Rumus Harris Bennedict
    @Override
    public double kaloriPria(double b1, double t1, int u1) {
    return (b1*13.8+66.5) + (t1*5) - (u1*6.8);

    }
    @Override
    public double kaloriWanita(double b2, double t2, int u2) {
    return (b2*9.6+66.5) + (t2*1.9) - (u2*4.7);

}

}
