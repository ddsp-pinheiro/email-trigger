package com.emailtrigger.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender emailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(String email) {
        try{
            MimeMessage mailMessage = emailSender.createMimeMessage();
            MimeMessageHelper helper  = new MimeMessageHelper(mailMessage, "utf-8");
            helper.setSubject("Welcome to ULTRA-COIN \uD83E\uDE99!");
            helper.setFrom(emailFrom);
            String htmlMsg = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                    "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                    "<head>\n" +
                    "<!--[if gte mso 9]>\n" +
                    "<xml>\n" +
                    "  <o:OfficeDocumentSettings>\n" +
                    "    <o:AllowPNG/>\n" +
                    "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                    "  </o:OfficeDocumentSettings>\n" +
                    "</xml>\n" +
                    "<![endif]-->\n" +
                    "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                    "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                    "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                    "  <title></title>\n" +
                    "  \n" +
                    "    <style type=\"text/css\">\n" +
                    "      @media only screen and (min-width: 620px) {\n" +
                    "  .u-row {\n" +
                    "    width: 600px !important;\n" +
                    "  }\n" +
                    "  .u-row .u-col {\n" +
                    "    vertical-align: top;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-49p67 {\n" +
                    "    width: 298.02px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-50 {\n" +
                    "    width: 300px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-50p33 {\n" +
                    "    width: 301.98px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "  .u-row .u-col-100 {\n" +
                    "    width: 600px !important;\n" +
                    "  }\n" +
                    "\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width: 620px) {\n" +
                    "  .u-row-container {\n" +
                    "    max-width: 100% !important;\n" +
                    "    padding-left: 0px !important;\n" +
                    "    padding-right: 0px !important;\n" +
                    "  }\n" +
                    "  .u-row .u-col {\n" +
                    "    min-width: 320px !important;\n" +
                    "    max-width: 100% !important;\n" +
                    "    display: block !important;\n" +
                    "  }\n" +
                    "  .u-row {\n" +
                    "    width: calc(100% - 40px) !important;\n" +
                    "  }\n" +
                    "  .u-col {\n" +
                    "    width: 100% !important;\n" +
                    "  }\n" +
                    "  .u-col > div {\n" +
                    "    margin: 0 auto;\n" +
                    "  }\n" +
                    "}\n" +
                    "body {\n" +
                    "  margin: 0;\n" +
                    "  padding: 0;\n" +
                    "}\n" +
                    "\n" +
                    "table,\n" +
                    "tr,\n" +
                    "td {\n" +
                    "  vertical-align: top;\n" +
                    "  border-collapse: collapse;\n" +
                    "}\n" +
                    "\n" +
                    "p {\n" +
                    "  margin: 0;\n" +
                    "}\n" +
                    "\n" +
                    ".ie-container table,\n" +
                    ".mso-container table {\n" +
                    "  table-layout: fixed;\n" +
                    "}\n" +
                    "\n" +
                    "* {\n" +
                    "  line-height: inherit;\n" +
                    "}\n" +
                    "\n" +
                    "a[x-apple-data-detectors='true'] {\n" +
                    "  color: inherit !important;\n" +
                    "  text-decoration: none !important;\n" +
                    "}\n" +
                    "\n" +
                    "@media (max-width: 480px) {\n" +
                    "  .hide-mobile {\n" +
                    "    max-height: 0px;\n" +
                    "    overflow: hidden;\n" +
                    "    display: none !important;\n" +
                    "  }\n" +
                    "}\n" +
                    "\n" +
                    "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } #u_content_text_8 a { color: #f1c40f; } @media (max-width: 480px) { #u_content_image_4 .v-container-padding-padding { padding: 60px 10px 0px !important; } #u_content_heading_5 .v-container-padding-padding { padding: 30px 10px 0px !important; } #u_content_heading_5 .v-text-align { text-align: center !important; } #u_content_text_5 .v-container-padding-padding { padding: 10px 30px !important; } #u_content_text_5 .v-text-align { text-align: center !important; } #u_content_button_4 .v-container-padding-padding { padding: 10px 10px 40px !important; } #u_content_button_4 .v-text-align { text-align: center !important; } #u_column_6 .v-col-background-color { background-color: #2c2c2c !important; } #u_content_heading_2 .v-container-padding-padding { padding: 30px 10px 0px !important; } #u_content_heading_2 .v-text-align { text-align: center !important; } #u_content_text_1 .v-container-padding-padding { padding: 10px 30px !important; } #u_content_text_1 .v-text-align { text-align: center !important; } #u_content_button_2 .v-container-padding-padding { padding: 10px !important; } #u_content_button_2 .v-button-colors { color: #FFFFFF !important; background-color: #0d1112 !important; } #u_content_button_2 .v-button-colors:hover { color: #FFFFFF !important; background-color: #3AAEE0 !important; } #u_content_button_2 .v-text-align { text-align: center !important; } #u_column_7 .v-col-background-color { background-color: #2c2c2c !important; } #u_content_image_2 .v-container-padding-padding { padding: 30px 10px 0px !important; } #u_content_heading_4 .v-container-padding-padding { padding: 30px 10px 0px 30px !important; } #u_content_heading_4 .v-text-align { text-align: center !important; } #u_content_text_3 .v-container-padding-padding { padding: 10px 30px !important; } #u_content_text_3 .v-text-align { text-align: center !important; } #u_content_button_3 .v-container-padding-padding { padding: 10px 10px 40px !important; } #u_content_button_3 .v-text-align { text-align: center !important; } #u_content_text_8 .v-container-padding-padding { padding: 60px 20px 0px !important; } #u_content_menu_1 .v-padding { padding: 5px 9px !important; } }\n" +
                    "    </style>\n" +
                    "  \n" +
                    "  \n" +
                    "\n" +
                    "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><link href=\"https://fonts.googleapis.com/css?family=Rubik:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                    "\n" +
                    "</head>\n" +
                    "\n" +
                    "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #0d1112;color: #000000\">\n" +
                    "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                    "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                    "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #0d1112;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                    "  <tbody>\n" +
                    "  <tr style=\"vertical-align: top\">\n" +
                    "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #0d1112;\"><![endif]-->\n" +
                    "    \n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 0px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #f1c40f; line-height: 170%; text-align: center; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 40px;\">\n" +
                    "    <div>\n" +
                    "<div>\n" +
                    "<div>\n" +
                    "<div><strong>- ULTRA COIN -</strong></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:5px 30px 60px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">Welcome to the easiest</p>\n" +
                    "<p style=\"font-size: 14px; line-height: 140%;\">fintech to use!</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #2c2c2c\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #2c2c2c;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" class=\"v-col-background-color\" style=\"background-color: #2c2c2c;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #2c2c2c;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 170%;\"><span style=\"font-size: 36px; line-height: 61.2px;\"><span style=\"line-height: 61.2px; font-size: 36px;\"><strong>More practicality for you !</strong></span></span></p>\n" +
                    "<p style=\"font-size: 14px; line-height: 170%;\">we hope this is just the beginning of a long journey together.</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"298\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 298px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-49p67\" style=\"max-width: 320px;min-width: 298.02px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_4\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-7.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 80%;max-width: 222.42px;\" width=\"222.42\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"301\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 301px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-50p33\" style=\"max-width: 320px;min-width: 301.98px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_heading_5\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:90px 10px 0px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 22px;\">\n" +
                    "    <div>\n" +
                    "<div>\n" +
                    "<div><strong>Make transfers to your friends</strong></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_5\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 15px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">Lorem ipsum dolor sit amet, us cones tutor adip.</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_button_4\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 10px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div class=\"v-text-align\" align=\"left\">\n" +
                    "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Montserrat',sans-serif;\"><tr><td class=\"v-text-align v-button-colors\" style=\"font-family:'Montserrat',sans-serif;\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.unlayer.com\" style=\"height:37px; v-text-anchor:middle; width:169px;\" arcsize=\"11%\" stroke=\"f\" fillcolor=\"#f1c40f\"><w:anchorlock/><center style=\"color:#000000;font-family:'Montserrat',sans-serif;\"><![endif]-->\n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_blank\" class=\"v-button-colors\" style=\"box-sizing: border-box;display: inline-block;font-family:'Montserrat',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #f1c40f; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:65%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-style: solid; border-top-width: 0px; border-left-style: solid; border-left-width: 0px; border-right-style: solid; border-right-width: 0px; border-bottom-style: solid; border-bottom-width: 0px;\">\n" +
                    "      <span class=\"v-padding\" style=\"display:block;padding:10px 20px;line-height:120%;\"><p style=\"font-size: 14px; line-height: 120%;\"><strong><span style=\"font-size: 14px; line-height: 16.8px;\">Go !</span></strong></p></span>\n" +
                    "    </a>\n" +
                    "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 300px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div id=\"u_column_6\" class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_heading_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 0px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 22px;\">\n" +
                    "    <div>\n" +
                    "<div>\n" +
                    "<div><strong>Here your money pays more</strong></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 15px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">Lorem ipsum dolor sit amet, us cones tutor adip.</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_button_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 10px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div class=\"v-text-align\" align=\"left\">\n" +
                    "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Montserrat',sans-serif;\"><tr><td class=\"v-text-align v-button-colors\" style=\"font-family:'Montserrat',sans-serif;\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.unlayer.com\" style=\"height:37px; v-text-anchor:middle; width:169px;\" arcsize=\"11%\" stroke=\"f\" fillcolor=\"#f1c40f\"><w:anchorlock/><center style=\"color:#000000;font-family:'Montserrat',sans-serif;\"><![endif]-->\n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_blank\" class=\"v-button-colors\" style=\"box-sizing: border-box;display: inline-block;font-family:'Montserrat',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #f1c40f; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:65%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-style: solid; border-top-width: 0px; border-left-style: solid; border-left-width: 0px; border-right-style: solid; border-right-width: 0px; border-bottom-style: solid; border-bottom-width: 0px;\">\n" +
                    "      <span class=\"v-padding\" style=\"display:block;padding:10px 20px;line-height:120%;\"><p style=\"font-size: 14px; line-height: 120%;\"><strong><span style=\"font-size: 14px; line-height: 16.8px;\">Shop Now</span></strong></p></span>\n" +
                    "    </a>\n" +
                    "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 300px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div id=\"u_column_7\" class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-6.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 78%;max-width: 218.4px;\" width=\"218.4\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 300px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_image_2\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                    "  <tr>\n" +
                    "    <td class=\"v-text-align\" style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                    "      \n" +
                    "      <img align=\"center\" border=\"0\" src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-5.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 77%;max-width: 215.6px;\" width=\"215.6\"/>\n" +
                    "      \n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "</table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"300\" class=\"v-col-background-color\" style=\"background-color: #0d1112;width: 300px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-50\" style=\"max-width: 320px;min-width: 300px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #0d1112;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_heading_4\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 0px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <h1 class=\"v-text-align\" style=\"margin: 0px; color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word; font-weight: normal; font-family: 'Rubik',sans-serif; font-size: 22px;\">\n" +
                    "    <div>\n" +
                    "<div>\n" +
                    "<div><strong>Create as many accounts as you want !</strong></div>\n" +
                    "</div>\n" +
                    "</div>\n" +
                    "  </h1>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_text_3\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 30px 15px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">Lorem ipsum dolor sit amet, us cones tutor adip.</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_button_3\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 10px 30px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div class=\"v-text-align\" align=\"left\">\n" +
                    "  <!--[if mso]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-spacing: 0; border-collapse: collapse; mso-table-lspace:0pt; mso-table-rspace:0pt;font-family:'Montserrat',sans-serif;\"><tr><td class=\"v-text-align v-button-colors\" style=\"font-family:'Montserrat',sans-serif;\" align=\"left\"><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.unlayer.com\" style=\"height:37px; v-text-anchor:middle; width:169px;\" arcsize=\"11%\" stroke=\"f\" fillcolor=\"#f1c40f\"><w:anchorlock/><center style=\"color:#000000;font-family:'Montserrat',sans-serif;\"><![endif]-->\n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_blank\" class=\"v-button-colors\" style=\"box-sizing: border-box;display: inline-block;font-family:'Montserrat',sans-serif;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #f1c40f; border-radius: 4px;-webkit-border-radius: 4px; -moz-border-radius: 4px; width:65%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;border-top-style: solid; border-top-width: 0px; border-left-style: solid; border-left-width: 0px; border-right-style: solid; border-right-width: 0px; border-bottom-style: solid; border-bottom-width: 0px;\">\n" +
                    "      <span class=\"v-padding\" style=\"display:block;padding:10px 20px;line-height:120%;\"><p style=\"font-size: 14px; line-height: 120%;\"><strong><span style=\"font-size: 14px; line-height: 16.8px;\">Shop Now</span></strong></p></span>\n" +
                    "    </a>\n" +
                    "  <!--[if mso]></center></v:roundrect></td></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "<div class=\"u-row-container\" style=\"padding: 0px;background-color: #2c2c2c\">\n" +
                    "  <div class=\"u-row\" style=\"Margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                    "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                    "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: #2c2c2c;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                    "      \n" +
                    "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" class=\"v-col-background-color\" style=\"background-color: #2c2c2c;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                    "  <div class=\"v-col-background-color\" style=\"background-color: #2c2c2c;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                    "  <!--[if (!mso)&(!IE)]><!--><div style=\"height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                    "  \n" +
                    "<table id=\"u_content_text_8\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 30px 0px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <div class=\"v-text-align\" style=\"color: #ffffff; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
                    "    <p style=\"font-size: 14px; line-height: 140%;\">If you have any questions, please email us at <a rel=\"noopener\" href=\"https://www.unlayer.com\" target=\"_blank\">ultra.coin.start@gmail.com</a> or visit our FAQS, you can also chat with a reel live human during our operating hours. They can answer questions about your account</p>\n" +
                    "  </div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:20px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"52%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #ffffff;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                    "    <tbody>\n" +
                    "      <tr style=\"vertical-align: top\">\n" +
                    "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                    "          <span>&#160;</span>\n" +
                    "        </td>\n" +
                    "      </tr>\n" +
                    "    </tbody>\n" +
                    "  </table>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div align=\"center\">\n" +
                    "  <div style=\"display: table; max-width:187px;\">\n" +
                    "  <!--[if (mso)|(IE)]><table width=\"187\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:187px;\"><tr><![endif]-->\n" +
                    "  \n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://facebook.com/\" title=\"Facebook\" target=\"_blank\">\n" +
                    "          <img src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-2.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://twitter.com/\" title=\"Twitter\" target=\"_blank\">\n" +
                    "          <img src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-1.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 15px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 15px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://linkedin.com/\" title=\"LinkedIn\" target=\"_blank\">\n" +
                    "          <img src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-4.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                    "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                    "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                    "        <a href=\"https://instagram.com/\" title=\"Instagram\" target=\"_blank\">\n" +
                    "          <img src=\"https://raw.githubusercontent.com/ddsp-pinheiro/email-trigger/main/images/image-3.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                    "        </a>\n" +
                    "      </td></tr>\n" +
                    "    </tbody></table>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "    \n" +
                    "    \n" +
                    "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "<table id=\"u_content_menu_1\" style=\"font-family:'Montserrat',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                    "  <tbody>\n" +
                    "    <tr>\n" +
                    "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:'Montserrat',sans-serif;\" align=\"left\">\n" +
                    "        \n" +
                    "<div class=\"menu\" style=\"text-align:center\">\n" +
                    "<!--[if (mso)|(IE)]><table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\"><tr><![endif]-->\n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding\">\n" +
                    "      Home\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px\" class=\"v-padding hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding\">\n" +
                    "      Page\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px\" class=\"v-padding hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding\">\n" +
                    "      About Us\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "    <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "    <span style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px\" class=\"v-padding hide-mobile\">\n" +
                    "      |\n" +
                    "    </span>\n" +
                    "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "  <!--[if (mso)|(IE)]><td style=\"padding:5px 15px\"><![endif]-->\n" +
                    "  \n" +
                    "    <a href=\"https://www.unlayer.com\" target=\"_self\" style=\"padding:5px 15px;display:inline-block;color:#ffffff;font-family:'Montserrat',sans-serif;font-size:14px;text-decoration:none\"  class=\"v-padding\">\n" +
                    "      Contact Us\n" +
                    "    </a>\n" +
                    "  \n" +
                    "  <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "  \n" +
                    "\n" +
                    "<!--[if (mso)|(IE)]></tr></table><![endif]-->\n" +
                    "</div>\n" +
                    "\n" +
                    "      </td>\n" +
                    "    </tr>\n" +
                    "  </tbody>\n" +
                    "</table>\n" +
                    "\n" +
                    "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                    "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                    "    </div>\n" +
                    "  </div>\n" +
                    "</div>\n" +
                    "\n" +
                    "\n" +
                    "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                    "    </td>\n" +
                    "  </tr>\n" +
                    "  </tbody>\n" +
                    "  </table>\n" +
                    "  <!--[if mso]></div><![endif]-->\n" +
                    "  <!--[if IE]></div><![endif]-->\n" +
                    "</body>\n" +
                    "\n" +
                    "</html>\n";
            helper.setText(htmlMsg, true);
            helper.setTo(email);
            emailSender.send(mailMessage);

        } catch (MailException | MessagingException e){
            log.error(e.getMessage());
        }
    }

}
