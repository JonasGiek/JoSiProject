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
		//VCFCodec codec = new VCFCodec();
		//if(codec.canDecode("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz")){
		long seed = System.nanoTime();
		File vcfFile = new File("filtered.vcf");
		VCFFileReader reader = new VCFFileReader(vcfFile, false);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = iter.next();
		Set<String> names = variant.getSampleNames();
		ArrayList namelist = new ArrayList(names);
		int size = namelist.size();
		int shrinkingSize = namelist.size();
		int sizeOfGroups = 8;
		Random rdm = new Random(seed);
		ArrayList <ArrayList<String>> groups = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < (size/sizeOfGroups)-1; i++) {
			ArrayList<String> L = new ArrayList<String>();
			for (int j = 0; j <sizeOfGroups; j++) {
				int ind = rdm.nextInt(shrinkingSize);
				String S = namelist.get(ind).toString();
				L.add(S);
				namelist.remove(ind);
				groups.add(L);
				shrinkingSize--;
			}
			
		}
		Genotype gen1 = variant.getGenotype(0);
		Genotype gen2 = variant.getGenotype(43);
		
		if (gen1.isHom()) {
			System.out.println("0 är homo");
		}
		if (gen2.isHet()) {
			System.out.println("43 är hetero");
		}
		System.out.println(gen1.getGenotypeString() + "," +gen2.getGenotypeString());
		System.out.println(seed);
		reader.close();
		//IntervalList list = VCFFileReader.fromVcf(vcfFile);
		//System.out.println("kan avkoda");
	}
}
