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
		List<String> names = new ArrayList<String>();

		while (scan.hasNext()){
			scan.nextInt();         // read and skip first column
			names.add(scan.next()); // read and store 'name'
			scan.nextLine();         // read and skip rest of line
		}
		scan.close();
		File vcfFile = new File("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz");
		VCFFileReader reader = new VCFFileReader(vcfFile);
		CloseableIterator<VariantContext> iter = reader.iterator();
		VariantContext variant = iter.next();
		int count = 0;
		while(iter.hasNext()) {
			count++;
			iter.next();
		}

		System.out.println(names.get(2500000));
		System.out.println(variant.getID());
		System.out.println(count);
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
