SUMMARY = "Astrophotography camera control software"
HOMEPAGE = "https://astrometry.net/"
LICENSE = "GPL-3.0"

SRC_URI += "git://git@github.com/dstndstn/astrometry.net.git;protocol=ssh;nobranch=1;branch=main"
SRCREV = "6de517a165db3e457c4dd542cf355d429995a692"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=71e53350ee5227c22dae3b0406fa53d1 \
"

DEPENDS += "cairo libpng libjpeg-turbo libzip bzip2 python3 python3-numpy swig netpbm cfitsio fitsio"

#inherit autotools
inherit pkgconfig

do_compile () {
    export ARCH_FLAGS=""
    # Build solving system
    oe_runmake
    # Build plotting code
    #oe_runmake extra
}