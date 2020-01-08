/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi4;

public class Comp extends Atom {

    private Atom[] electrons_next;
    private Atom[] el;
    private int i;
    private int j;

    public Comp(Atom[] all_carbons, int desmos, int id) {
        el = all_carbons[id].get_electrons();
        if (desmos == 1) // single
        {
            i = 0;
            j = 0;
            while (i < 4 && j < 1) // enwsh C[id] me C[id+1]
            {
                if (el[i] == null) 
                {
                    el[i] = all_carbons[id + 1];
                    j++;
                }
                i++;
            }
            i = 0;
            while (i < 4) // sumplhrwsh H
            {
                if (el[i] == null) 
                {
                    sum_h++;
                    el[i] = new Atom(1, sum_h);
                }
                i++;
            }

            // C[id+1]
            electrons_next = all_carbons[id + 1].get_electrons();
            i = 0;
            j = 0;
            while (i < 4 && j < 1) // enwsh C[id+1] me C[id]
            {
                if (electrons_next[i] == null) 
                {
                    electrons_next[i] = all_carbons[id]; // C proigoumeno
                    j++;
                }
                i++;
            }
        } 
        else if ((desmos == 2) && (pollaplos == 0)) // DOUBLE
        {
            pollaplos = 1;
            // C[id] //
            i = 0;
            j = 0;
            while (i < 4 && j < 2) // enwsh C[id] me C[id+1]
            {
                if (el[i] == null) 
                {
                    el[i] = all_carbons[id + 1]; //C epomeno
                    j++;
                }
                i++;
            }
            i = 0;
            while (i < 4) // sumplhrwsh H
            {
                if (el[i] == null) 
                {
                    sum_h++;
                    el[i] = new Atom(1, sum_h);
                }
                i++;
            }

            //C [id+1] //
            electrons_next = all_carbons[id + 1].get_electrons();

            i = 0;
            j = 0;
            while (i < 4 && j < 2) // enwsh C[id+1] me C[id]
            {
                if (electrons_next[i] == null) 
                {
                    electrons_next[i] = all_carbons[id]; //C proigoumeno
                    j++;
                }
                i++;
            }
        } else if ((desmos == 3) && (pollaplos == 0)) //  TRIPLE
        {
            pollaplos = 1;
            // C[id] //
            i = 0;
            j = 0;
            while (i < 4 && j < 3) // enwsh C[id] me C[id+1]
            {
                if (el[i] == null) 
                {
                    el[i] = all_carbons[id + 1]; //C epomeno
                    j++;
                }
                i++;
            }
            i = 0;
            while (i < 4) //  sumplhrwsh H
            {
                if (el[i] == null) 
                {
                    sum_h++;
                    el[i] = new Atom(1, sum_h);
                }
                i++;
            }

            // C[id+1] //
            electrons_next = all_carbons[id + 1].get_electrons();

            i = 0;
            j = 0;
            while (i < 4 && j < 3) // enwsh C[id+1] me C[id]
            {
                if (electrons_next[i] == null) 
                {
                    electrons_next[i] = all_carbons[id]; //C proigoumeno
                    j++;
                }
                i++;
            }
        } else // NONE
        {
            pollaplos = 0;
            // C[id]
            for (int k = 0; k < 4; k++) {
                if (el[k] == null) {
                    sum_h++;
                    el[k] = new Atom(1, sum_h);  // sumplhrwsh H
                }
            }
        }
    }

    public void print_comp (Atom[] all_carbons, int carbons, int i)
    {
	int next = 0, prev = 0;
        String str;

        el = all_carbons[i].get_electrons();

        if (carbons != 1)
        {
            for (int k = 0; k < 4; k++) 
            {
                if (el[k] == all_carbons[i + 1]) // an sundeetai me C meta kai posa
                    next++;
                if ((i != 0) && (el[k] == all_carbons[i - 1])) // an sundeetai me C prin kai posa
                    prev++;
            }
        }

        if ((prev == 0) && (flag == 0))
        {
            System.out.println();
            System.out.print("comp([");
        }

        if ((next == 0) && (flag == 0)) // an einai ena mono tou 'h an teleiwnei o desmos
        {
            System.out.print("C" + Integer.toString(i + 1) + "(");
            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = el[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = el[k].get_atom_id();
                    System.out.print(str);
                    if (k != 3)
                    {
                        System.out.print(",");
                    }
                    h++;
                }
            }
            System.out.println(")])  " + "ALKANIO");
        } 
        else if (next == 1) // SINGLE
        {
            if (prev == 1)
                h -= 2;
            
            System.out.print("C" + Integer.toString(i+1) + "(C" + Integer.toString(i+2) + "(single)");
            for (int k = 0; k < 4; k++) 
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = el[k].get_atom_id();
                if (str1.equals(str2))
                {
                    str = el[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print("), ");
            System.out.print("C" + Integer.toString(i+2) + "(C" + Integer.toString(i+1) + "(single)");

            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = electrons_next[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = electrons_next[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print(") ");
            flag = 1;
        } 
        else if (next == 2) // DOUBLE
        {
            alkenio = 1;
            System.out.print("C" + Integer.toString(i+1) + "(C" + Integer.toString(i+2) + "(double)");
            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = el[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = el[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print("), ");
            System.out.print("C" + Integer.toString(i+2) + "(C" + Integer.toString(i+1) + "(double)");            

            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = electrons_next[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = electrons_next[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print(") ");
            flag = 1;
        } 
        else if (next == 3) // TRIPLE
        {
            alkinio = 1;
            System.out.print("C" + Integer.toString(i+1) + "(C" + Integer.toString(i+2) + "(triple)");
            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = el[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = el[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print("), ");
            System.out.print("C" + Integer.toString(i+2) + "(C" + Integer.toString(i+1) + "(triple)");                        

            for (int k = 0; k < 4; k++)
            {
                String str1 = "H" + Integer.toString(h);
                String str2 = electrons_next[k].get_atom_id();
                if (str1.equals(str2))
		{
                    str = electrons_next[k].get_atom_id();
                    System.out.print("," + str);
                    h++;
                }
            }
            System.out.print(") ");
            flag = 1;
        }

        if (next == 0)
        {
            if (flag != 0)
            {
                System.out.print("])  ");
                if (alkenio == 1)
                {
                    System.out.println("ALKENIO");
                    alkenio = 0;
                } else if (alkinio == 1)
                {
                    System.out.println("ALKINIO");
                    alkinio = 0;
                } else
                {
                    System.out.println("ALKANIO");
                }
            }
            flag = 0;
        }
    }
}
