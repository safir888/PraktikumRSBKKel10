/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalori.ejb;

import javax.ejb.Local;

/**
 *
 * @author User ID
 */
@Local
public interface HitungKaloriBeanLocal {

public double kaloriPria(double b1, double t1, int u1);
public double kaloriWanita(double b2, double t2, int u2);
}
