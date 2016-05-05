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
import java.util.ArrayList;
import java.util.Scanner;


class RandomGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//VCFCodec codec = new VCFCodec();
		//if(codec.canDecode("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz")){

		File vcfFile = new File("filtered.vcf");
		VCFFileReader reader = new VCFFileReader(vcfFile, false);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = iter.next();
		//variant = iter.next();
		//variant = iter.next();
		/*for (int j = 0; j < 2500; j++) {
			Genotype gen = variant.getGenotype(j);
			System.out.println(gen.toString());
	}*/
			//(HG00143	HG00145 har 1 / 0)
			//variant.getSampleNames();
			//List L = gen.getAlleles();
		Genotype gen1 = variant.getGenotype(0);
		Genotype gen2 = variant.getGenotype(43);
		
		if (gen1.isHom()) {
			System.out.println("0 är homo");
		}
		if (gen2.isHet()) {
			System.out.println("43 är hetero");
		}
		System.out.println(gen1.getGenotypeString() + "," +gen2.getGenotypeString());
		reader.close();
		//IntervalList list = VCFFileReader.fromVcf(vcfFile);
		//System.out.println("kan avkoda");
	}
}
