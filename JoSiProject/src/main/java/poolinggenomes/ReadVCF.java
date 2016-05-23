/**
 * @author Jonas Giek & Simon Stromstedt Hallberg
 *attempt at reading a VCF
 */
package poolinggenomes;

import htsjdk.samtools.util.CloseableIterator;
import htsjdk.variant.vcf.VCFFileReader;
import htsjdk.variant.variantcontext.VariantContext;
import htsjdk.variant.variantcontext.writer.VariantContextWriter;
import htsjdk.variant.variantcontext.writer.VariantContextWriterBuilder;
import htsjdk.variant.variantcontext.writer.Options;
import htsjdk.variant.vcf.VCFHeader;
import htsjdk.samtools.SAMSequenceDictionary;
import java.util.HashSet;
import java.io.*;
import java.util.Scanner;
public class ReadVCF {

	/**
	 * @param args
	 * The first argument is the filename of marker names that the program will filter the .vcf-file against.
	 * The second argument is the filename of the .vcf or vcf.gz-file you want to filter.
	 * The third argument is the name of the output file.   
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(args[0]));
		HashSet<String> names = new HashSet<String>();
		int countfilter= 0;
		int countgrundfil= 0;
		while (scan.hasNext()){
			scan.nextInt();    
			names.add(scan.next());
			countfilter++;
			scan.nextLine();        
		}
		scan.close();
		File vcfFile = new File(args[1]);
		VCFFileReader reader = new VCFFileReader(vcfFile);
		SAMSequenceDictionary dic = VCFFileReader.getSequenceDictionary(vcfFile);
		VCFHeader header = reader.getFileHeader();
		VariantContextWriterBuilder builder = new VariantContextWriterBuilder()
			       .setReferenceDictionary(dic)
			       .setOption(Options.INDEX_ON_THE_FLY);
			   VariantContextWriter writer = builder
			       .setOutputFile(args[3])
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
			countgrundfil++;
		}
	    System.out.println(count);
	    System.out.println(countfilter);
	    System.out.println(countgrundfil);
		System.out.println();
		System.out.println(variant.getID());
		reader.close();

	}
}
