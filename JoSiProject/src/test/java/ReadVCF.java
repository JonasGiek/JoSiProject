		/**
		 * 
		 */
		
		/**
		 * @author jonasgiek
		 *attempt at reading a VCF
		 */
	
import htsjdk.samtools.util.IntervalList;
import htsjdk.variant.vcf.VCFFileReader;
import htsjdk.variant.vcf.VCFCodec;
import htsjdk.variant.variantcontext.VariantContext;
import java.io.*;
		public class ReadVCF {
			
			/**
			 * @param args
			 */
			public static void main(String[] args) {
				//VCFCodec codec = new VCFCodec();
				//if(codec.canDecode("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz")){
				File vcfFile = new File("ALL.chr11.phase3_shapeit2_mvncall_integrated_v5a.20130502.genotypes.vcf.gz");
				VCFFileReader reader = new VCFFileReader(vcfFile);
				//IntervalList list = VCFFileReader.fromVcf(vcfFile);
					//System.out.println("kan avkoda");
				//
				for (final VariantContext vc : reader.iterator()) {
	                if (writer != null){
	                    writer.add(vc);
	                }
			}	
			}
		}
