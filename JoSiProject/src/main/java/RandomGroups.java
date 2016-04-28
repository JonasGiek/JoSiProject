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

		File vcfFile = new File("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz");
		VCFFileReader reader = new VCFFileReader(vcfFile);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = iter.next();
		variant.getSampleNames();
	
		
	    System.out.println();
		System.out.println(variant.getSampleNames());
		System.out.println(variant.getID());
		reader.close();
		//IntervalList list = VCFFileReader.fromVcf(vcfFile);
		//System.out.println("kan avkoda");
	}
}
