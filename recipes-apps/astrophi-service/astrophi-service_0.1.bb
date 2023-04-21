DESCRIPTION = "Astrophi systemd service"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://astrophi.service"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN}:append = " astrophi.service  "

RDEPENDS:${PN} = "astrophi"

do_install:append () {
   install -d ${D}${sysconfdir}/systemd/system/
   install -m 0644 ${WORKDIR}/astrophi.service ${D}${sysconfdir}/systemd/system/
}