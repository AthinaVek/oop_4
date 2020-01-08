/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package askisi4;

public class Atom extends Global {
    // Fields
    private String atom_id;
    private Atom[] electrons;
    private int typos;
    
    // Methods
    public Atom (int t, int id) {
        typos = t;
        electrons = new Atom[typos];
        for (int i=0; i<typos; i++)
            electrons[i] = null;
        if (typos == 4)  // an einai C
            set_atom_id("C" + Integer.toString(id+1));
        else if (typos == 1) // an einai H
            set_atom_id("H" + Integer.toString(id));
    }
    
    public Atom() {};
    
    public void set_atom_id(String s) {
        atom_id = s;
    }
    
    public String get_atom_id() {
        return atom_id;
    }
    
    public Atom[] get_electrons() {
        return electrons;
    }
    
    public void print_atom_id() {
        System.out.println("Atom id: " + atom_id);
        System.out.println();
    }
}
