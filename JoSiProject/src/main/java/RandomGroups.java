import htsjdk.samtools.util.CloseableIterator;
import htsjdk.variant.vcf.VCFFileReader;
import htsjdk.variant.variantcontext.VariantContext;
import java.io.*;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;


class RandomGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		long seed = System.nanoTime();
		// long seed = null;
		File vcfFile = new File("filtered.vcf");
		VCFFileReader reader = new VCFFileReader(vcfFile, false);
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variantForNames = iter.next();
		Set<String> names = variantForNames.getSampleNames();
		ArrayList <String> namelist = new ArrayList(names);
		int size = namelist.size();
		int shrinkingSize = namelist.size();
		int sizeOfGroups = 8;
		Random rdm = new Random(seed);
		String seedToName = String.valueOf(seed)+".txt";
		ArrayList <ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < (size/sizeOfGroups); i++) {
			ArrayList<String> L = new ArrayList<String>();
			for (int j = 0; j <sizeOfGroups; j++) {
				int ind = rdm.nextInt(shrinkingSize);
				String S = namelist.get(ind).toString();
				L.add(S);
				namelist.remove(ind);
				shrinkingSize--;
			}
			groups.add(L);
		}
		iter.close();
		CloseableIterator<VariantContext> iter2 = reader.iterator();
		VariantContext variant = null;
		int countmarkers=0;
		PrintWriter outputStream=new PrintWriter(seedToName);
		//PrintWriter outputStream=new PrintWriter(seedToName+"replica.txt");
		while (iter2.hasNext()) {
			variant = iter2.next();
			countmarkers++;
			int count = 0;
			variant.getGenotype(groups.get(j).get(7))
			for (int j = 0; j < groups.size(); j++) {
				if (variant.getGenotype(groups.get(j).get(0)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
						&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
						&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
						|| variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
								&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
						|| variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
								&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(0)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(1)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
						&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
						|| variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
								&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
						|| variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
								&& variant.getGenotype(groups.get(j).get(1)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(2)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
						&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
						|| variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
								&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
						|| variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
								&& variant.getGenotype(groups.get(j).get(2)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(3)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
						&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
						|| variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
								&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
								&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))
						|| variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
								&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
								&& variant.getGenotype(groups.get(j).get(3)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(4)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
						&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
						|| variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
								&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
								&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
						|| variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
								&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
								&& variant.getGenotype(groups.get(j).get(4)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(5)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
						&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
						|| variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
								&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))
						|| variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
								&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(5)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(6)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(0)))
						&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
						&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
						|| variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
								&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
								&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))
						|| variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
								&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(6)).sameGenotype(variant.getGenotype(groups.get(j).get(7)))))
					count++;
				if (variant.getGenotype(groups.get(j).get(7)).isHom() 
						&& (variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(4)))
						&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))
						&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
						|| variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(2)))
								&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(6)))
						|| variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(1)))
								&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(3)))
								&& variant.getGenotype(groups.get(j).get(7)).sameGenotype(variant.getGenotype(groups.get(j).get(5)))))
					count++;
			} 
			outputStream.println(count);
		}
		 outputStream.close();

		System.out.println(seed);
		System.out.println(countmarkers);
		reader.close();

	}
}
