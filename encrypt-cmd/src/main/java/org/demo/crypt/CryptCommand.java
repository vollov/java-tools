package org.demo.crypt;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;

public class CryptCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CommandLineParser parser = new DefaultParser();

		// create the Options
		Options options = new Options();
		// add t option
		options.addOption("h", false, "print this message");
		options.addOption("p", true, "db password");
		options.addOption("a", true, "actions <encrypt | decrypt>");
		options.addOption("t", true, "table name");
		
		Option fieldsOption = new Option("f", "fields to crypt (upto 30 fields)");
		// Set option c to take maximum of 10 arguments
		fieldsOption.setArgs(Option.UNLIMITED_VALUES);
		options.addOption(fieldsOption);
		
		String tableName = "";
		String[] fields = null;
		String password = "";
		try {
			// parse the command line arguments
			CommandLine cmd = parser.parse(options, args);

			if (cmd.hasOption("h"))
				help(options);

			password = cmd.getOptionValue("p");

			if (password == null) {
				help(options);
			}
			
			tableName = cmd.getOptionValue("t");

			if (tableName == null) {
				help(options);
			}

			fields = cmd.getOptionValues("f");
			if (fields==null || fields.length < 1){
				help(options);
			}
			
			if(cmd.hasOption("a")) {
		        String value = cmd.getOptionValue("a");
		        if("encrypt".equals(value)) {
		        	System.out.print("encrypting");
		        } else if("decrypt".equals(value)) {
		        	System.out.print("decrypting");
		        } else {
		        	help(options);
		        }
		     } else {
		    	 help(options);
		     }
			
		} catch (ParseException exp) {
			System.out.println("Unexpected exception:" + exp.getMessage());
		}

		System.out.print(" password " + password);
		System.out.print(" table " + tableName);
		System.out.println(" on fields " + StringUtils.join(fields, ","));
//		for(String f: fields){
//			System.out.println("field:" + f);
//		}
		
	}
	
	private static void help(Options options) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp( "encrypt-cmd", options );
		System.exit(0);
	}

}
