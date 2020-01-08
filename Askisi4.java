/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi4;

/**
 *
 * @author kostas
 */
public class Askisi4 extends Global
{
    public static void main(String[] args)
    {
        int typos, carbons, desmos=0, i;
        
        if (args.length > 0)
        {
            if (isNumeric(args[0]))
            {
                int K = Integer.parseInt(args[0]);
                
                for (int p=0; p<K; p++)
                {
                    sum_h = 0; // udrogona
                    pollaplos = 0; // an uparxei hdh prin diplos 'h triplos
                    h = 1; // udrogona
                    flag = 0; //an exei tupwthei to c me to prev tou
                    alkenio = 0;
                    alkinio = 0;
                    
                    carbons = (int)(Math.random()*6) + 1;
                    
                    System.out.println("****************** " + (p+1) + " ********************");
                    System.out.println("Carbons: " + carbons);
                    Atom[] all_carbons = new Atom[carbons+1];
                    Comp[] desmoi = new Comp[carbons+1];
                    
                    // dhmiourgia carbons
                    typos = 4;
                    for (i=0; i<carbons; i++) 
                        all_carbons[i] = new Atom(typos, i);
                    
                    // dhmiourgia tuxaiwn desmwn
                    // (0=none,1=single,2=double,3=triple)
                    for (i=0; i<(carbons-1); i++)
                    {
                        desmos = (int)(Math.random()*4);
                        desmoi[i] = new Comp(all_carbons, desmos, i); // ginontai oi enwseis
                    }
                    
                    desmos = 0;
                    desmoi[i] = new Comp(all_carbons, desmos, i);

                    for (i=0; i<carbons; i++)
                    {
                        desmoi[i].print_comp(all_carbons, carbons, i);
                    }
                    
                    System.out.println();
                    System.out.println();
                }
            }
        }
    }
    
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
}
