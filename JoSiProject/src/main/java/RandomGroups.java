import htsjdk.samtools.util.IntervalList;
import htsjdk.samtools.util.CloseableIterator;
import htsjdk.variant.vcf.VCFFileReader;
import htsjdk.variant.vcf.VCFCodec;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.variantcontext.writer.VariantContextWriter;
import htsjdk.variant.variantcontext.writer.VariantContextWriterBuilder;
import htsjdk.variant.variantcontext.writer.Options;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.samtools.SAMSequenceDictionary;
import htsjdk.variant.variantcontext.GenotypesContext;
import htsjdk.variant.variantcontext.Genotype;
import java.util.HashSet;
import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.ListIterator;


class RandomGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		long seed = System.nanoTime();
		File vcfFile = new File("filtered.vcf");
		VCFFileReader reader = new VCFFileReader(vcfFile, false);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = iter.next();
		Set<String> names = variant.getSampleNames();
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
		PrintWriter outputStream=new PrintWriter(seedToName);
		while (iter.hasNext()) {
			
			int count = 0;
			for (int j = 0; j < groups.size(); j++) {
				if (variant.getGenotype(0).isHom() && (variant.getGenotype(0).sameGenotype(variant.getGenotype(1))
						&& variant.getGenotype(0).sameGenotype(variant.getGenotype(2))
						&& variant.getGenotype(0).sameGenotype(variant.getGenotype(3))
						|| variant.getGenotype(0).sameGenotype(variant.getGenotype(1))
								&& variant.getGenotype(0).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(0).sameGenotype(variant.getGenotype(5))
						|| variant.getGenotype(0).sameGenotype(variant.getGenotype(2))
								&& variant.getGenotype(0).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(0).sameGenotype(variant.getGenotype(6))))
					count++;
				if (variant.getGenotype(1).isHom() && (variant.getGenotype(1).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(1).sameGenotype(variant.getGenotype(2))
						&& variant.getGenotype(1).sameGenotype(variant.getGenotype(3))
						|| variant.getGenotype(1).sameGenotype(variant.getGenotype(0))
								&& variant.getGenotype(1).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(1).sameGenotype(variant.getGenotype(5))
						|| variant.getGenotype(1).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(1).sameGenotype(variant.getGenotype(5))
								&& variant.getGenotype(1).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(2).isHom() && (variant.getGenotype(2).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(2).sameGenotype(variant.getGenotype(1))
						&& variant.getGenotype(2).sameGenotype(variant.getGenotype(3))
						|| variant.getGenotype(2).sameGenotype(variant.getGenotype(0))
								&& variant.getGenotype(2).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(2).sameGenotype(variant.getGenotype(6))
						|| variant.getGenotype(2).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(2).sameGenotype(variant.getGenotype(6))
								&& variant.getGenotype(2).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(3).isHom() && (variant.getGenotype(3).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(3).sameGenotype(variant.getGenotype(1))
						&& variant.getGenotype(3).sameGenotype(variant.getGenotype(2))
						|| variant.getGenotype(3).sameGenotype(variant.getGenotype(2))
								&& variant.getGenotype(3).sameGenotype(variant.getGenotype(6))
								&& variant.getGenotype(3).sameGenotype(variant.getGenotype(7))
						|| variant.getGenotype(3).sameGenotype(variant.getGenotype(1))
								&& variant.getGenotype(3).sameGenotype(variant.getGenotype(5))
								&& variant.getGenotype(3).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(4).isHom() && (variant.getGenotype(4).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(4).sameGenotype(variant.getGenotype(1))
						&& variant.getGenotype(4).sameGenotype(variant.getGenotype(5))
						|| variant.getGenotype(4).sameGenotype(variant.getGenotype(0))
								&& variant.getGenotype(4).sameGenotype(variant.getGenotype(2))
								&& variant.getGenotype(4).sameGenotype(variant.getGenotype(6))
						|| variant.getGenotype(4).sameGenotype(variant.getGenotype(5))
								&& variant.getGenotype(4).sameGenotype(variant.getGenotype(6))
								&& variant.getGenotype(4).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(5).isHom() && (variant.getGenotype(5).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(5).sameGenotype(variant.getGenotype(1))
						&& variant.getGenotype(5).sameGenotype(variant.getGenotype(4))
						|| variant.getGenotype(5).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(5).sameGenotype(variant.getGenotype(6))
								&& variant.getGenotype(5).sameGenotype(variant.getGenotype(7))
						|| variant.getGenotype(5).sameGenotype(variant.getGenotype(1))
								&& variant.getGenotype(5).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(5).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(6).isHom() && (variant.getGenotype(6).sameGenotype(variant.getGenotype(0))
						&& variant.getGenotype(6).sameGenotype(variant.getGenotype(2))
						&& variant.getGenotype(6).sameGenotype(variant.getGenotype(4))
						|| variant.getGenotype(6).sameGenotype(variant.getGenotype(4))
								&& variant.getGenotype(6).sameGenotype(variant.getGenotype(5))
								&& variant.getGenotype(6).sameGenotype(variant.getGenotype(7))
						|| variant.getGenotype(6).sameGenotype(variant.getGenotype(2))
								&& variant.getGenotype(6).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(6).sameGenotype(variant.getGenotype(7))))
					count++;
				if (variant.getGenotype(7).isHom() && (variant.getGenotype(7).sameGenotype(variant.getGenotype(4))
						&& variant.getGenotype(7).sameGenotype(variant.getGenotype(5))
						&& variant.getGenotype(7).sameGenotype(variant.getGenotype(6))
						|| variant.getGenotype(7).sameGenotype(variant.getGenotype(2))
								&& variant.getGenotype(7).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(7).sameGenotype(variant.getGenotype(6))
						|| variant.getGenotype(7).sameGenotype(variant.getGenotype(1))
								&& variant.getGenotype(7).sameGenotype(variant.getGenotype(3))
								&& variant.getGenotype(7).sameGenotype(variant.getGenotype(5))))
					count++;
			} 
			variant = iter.next();
			outputStream.println(count);

		}
		 outputStream.close();

		System.out.println(groups.size());
		Genotype gen1 = variant.getGenotype(0);
		Genotype gen2 = variant.getGenotype(1);
		Genotype gen3 = variant.getGenotype(43);
		System.out.println(gen2.sameGenotype(gen1));
		if (gen1.isHom()) {
			System.out.println("0 är homo");
		}
		if (gen3.isHet()) {
			System.out.println("43 är hetero");
		}
		System.out.println(gen1.getGenotypeString() + "," +gen2.getGenotypeString());
		System.out.println(seed);
		reader.close();

	}
}
