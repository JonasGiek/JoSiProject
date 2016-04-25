		/**
		 * 
		 */
		
		/**
		 * @author jonasgiek
		 *attempt at reading a VCF
		 */
	
import htsjdk.samtools.util.IntervalList;
import htsjdk.variant.vcf.VCFFileReader;
import java.io.*;
		public class ReadVCF {
			
			/**
			 * @param args
			 */
			public static void main(String[] args) {
				
				File vcfFile = new File("trio.2010_06.ychr.sites.vcf.gz");
				IntervalList list = VCFFileReader.fromVcf(vcfFile);
			// needs to solve problems with tribble
			}
		}
