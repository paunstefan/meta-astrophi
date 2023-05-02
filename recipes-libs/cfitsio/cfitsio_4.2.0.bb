SUMMARY = "CFITSIO is a library of C and Fortran subroutines for reading and writing data files in FITS data format"
HOMEPAGE = "https://heasarc.gsfc.nasa.gov/fitsio/"
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   License.txt
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://License.txt;md5=77856e8a5492e2119200b3401a8e7966"

SRC_URI = "https://heasarc.gsfc.nasa.gov/FTP/software/fitsio/c/cfitsio-${PV}.tar.gz"
SRC_URI[md5sum] = "2aa08d626765868d22a875740667f400"
SRC_URI[sha256sum] = "eba53d1b3f6e345632bb09a7b752ec7ced3d63ec5153a848380f3880c5d61889"

DEPENDS = "zlib curl bzip2"
RDEPENDS:${PN} += "zlib curl bzip2"


inherit pkgconfig
inherit autotools-brokensep

TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
    install -d ${D}${libdir}
    install -d ${D}${includedir}
    install -d ${D}${libdir}/pkgconfig
    install -m 0755 ${WORKDIR}/cfitsio-${PV}/libcfitsio.a ${D}${libdir}/libcfitsio.a
    install -m 0755 ${WORKDIR}/cfitsio-${PV}/libcfitsio.so.10.${PV} ${D}${libdir}/libcfitsio.so.10.${PV}
    ln -s -r ${D}${libdir}/libcfitsio.so.10.${PV} ${D}${libdir}/libcfitsio.so.10
    ln -s -r ${D}${libdir}/libcfitsio.so.10 ${D}${libdir}/libcfitsio.so
    for header in fitsio.h fitsio2.h longnam.h drvrsmem.h
    do
        install -m 0755 ${WORKDIR}/cfitsio-${PV}/${header} ${D}${includedir}/${header}
    done
    install -m 0777 ${WORKDIR}/cfitsio-${PV}/cfitsio.pc ${D}${libdir}/pkgconfig/cfitsio.pc

    #install -d ${D}${bindir}
    # not installing util binaries yet
}

ERROR_QA:remove = "staticdev license-file-missing"
