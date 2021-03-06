package info.andersonsoares.model;


import info.andersonsoares.util.PrintArray;

import java.util.ArrayList;
import java.util.List;

/**
 * estrutura do cromossomo
 * @author aers
 *
 */
public class Chromosome
{
    private List<Boolean> chromosome;

    private Chromosome() {}

    public Chromosome(int length)
    {
        chromosome = new ArrayList<Boolean>(length);

        // initialize to random values
        for (int i = 0; i < length; i += 1)
            chromosome.add(Math.round(Math.random()) == 0);
    }

   
    
    public Chromosome(List<Boolean> bits) {
    	this.chromosome = bits;
	}

	public int size()
    {
        return chromosome.size();
    }

    public Boolean get(int index)
    {
        return chromosome.get(index);
    }

    public void set(int index, boolean value)
    {
        chromosome.set(index, value);
    }

    public int getRandIndex()
    {
        return (int) (Math.random() * chromosome.size());
    }

    public void flip(int index)
    {
    	chromosome.set(index, ! chromosome.get(index));
    }

    public int hammingDistanceTo(Chromosome otherChromosome)
    {
        if (chromosome.size() != otherChromosome.size())
            throw new IllegalArgumentException("Arity of operators unequal.");

        int distance = 0;

        for (int i = 0; i < chromosome.size(); i += 1)
            distance += chromosome.get(i) == otherChromosome.get(i) ? 0 : 1;

        return distance;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        
        for (Boolean i : chromosome)
            sb.append(i ? "1" : "0");

        return sb.toString();
    }
}
