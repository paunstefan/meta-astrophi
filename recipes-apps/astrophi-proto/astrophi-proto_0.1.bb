DESCRIPTION = "Astrophotography camera control prototype program"
LICENSE  = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
SRC_URI = "file://astrophi-proto"

RDEPENDS:${PN} = "python3-core \
                python3-multiprocessing \
                python3-configargparse \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0777 ${WORKDIR}/astrophi-proto ${D}/${bindir}
}