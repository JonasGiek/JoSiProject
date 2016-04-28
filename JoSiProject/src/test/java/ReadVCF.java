/**
 * 
 */

/**
 * @author jonasgiek
 *attempt at reading a VCF
 */

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
public class ReadVCF {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//VCFCodec codec = new VCFCodec();
		//if(codec.canDecode("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz")){
		Scanner scan = new Scanner(new File("InfiniumOmni2-5Exome-8v1-3_A1_455_LocusReport.txt"));
		HashSet<String> names = new HashSet<String>();

		while (scan.hasNext()){
			scan.nextInt();         // read and skip first column
			names.add(scan.next()); // read and store 'name'
			scan.nextLine();         // read and skip rest of line
		}
		scan.close();
		File vcfFile = new File("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz");
		VCFFileReader reader = new VCFFileReader(vcfFile);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		VariantContextWriterBuilder builder = new VariantContextWriterBuilder()
			  //     .setReferenceDictionary(refDict)
			       .unsetOption(Options.INDEX_ON_THE_FLY);
			      // .setBuffer(8192);
			 
			   VariantContextWriter writer = builder
			       .setOutputFile("filtered.vcf")
			       .build();
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = null;
		writer.writeHeader(header);
		int count= 0;
	    while (iter.hasNext()) {
			variant = iter.next();
			if (names.contains(variant.getID()) && variant!=null) {
				writer.add(variant);
				count++;
			}
			
			
		}
	    System.out.println(count);
		System.out.println();
		System.out.println(variant.getID());
		reader.close();
		//IntervalList list = VCFFileReader.fromVcf(vcfFile);
		//System.out.println("kan avkoda");
		//
		/*	for (final VariantContext vc : reader.iterator()) {
	                if (writer != null){
	                    writer.add(vc);
	                }

			}	*/

	}
}
