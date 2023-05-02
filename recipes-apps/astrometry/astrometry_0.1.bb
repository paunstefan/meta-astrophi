SUMMARY = "Astrometry software"
HOMEPAGE = "https://astrometry.net/"
LICENSE = "GPL-3.0"

SRC_URI += "git://git@github.com/dstndstn/astrometry.net.git;protocol=ssh;nobranch=1;branch=main"
SRCREV = "4f99e60317c7106654cab6105a48b94701956d19"
S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=71e53350ee5227c22dae3b0406fa53d1 \
"

DEPENDS += "gsl cairo libpng libjpeg-turbo libzip bzip2 python3 python3-numpy swig netpbm cfitsio fitsio"
DEPENDS += "python3-native python3-numpy-native"

RDEPENDS:${PN} += "gsl cairo libpng libjpeg-turbo libzip bzip2 python3 python3-numpy swig netpbm cfitsio fitsio"

SRC_URI += "file://have_netpbm.patch"


inherit pkgconfig

FILES:${PN} += "/usr/local/astrometry"

do_compile () {
    export ARCH_FLAGS=""
    echo "HAVE_NETPBM := yes" > ${WORKDIR}/git/util/makefile.os-features
    # Build solving system
    oe_runmake NETPBM_INC="-I${WORKDIR}/recipe-sysroot/usr/include/netpbm" NETPBM_LIB="-L${WORKDIR}/recipe-sysroot/usr/lib -lnetpbm"
    # Build plotting code
    oe_runmake extra NETPBM_INC="-I${WORKDIR}/recipe-sysroot/usr/include/netpbm" NETPBM_LIB="-L${WORKDIR}/recipe-sysroot/usr/lib -lnetpbm"
}

# Data files
SRC_URI += "http://data.astrometry.net/4100/index-4107.fits \
            http://data.astrometry.net/4100/index-4108.fits \
            http://data.astrometry.net/4100/index-4109.fits \
            http://data.astrometry.net/4100/index-4110.fits \
            http://data.astrometry.net/4100/index-4111.fits \
            http://data.astrometry.net/4100/index-4112.fits \
            http://data.astrometry.net/4100/index-4113.fits \
            http://data.astrometry.net/4100/index-4114.fits \
            http://data.astrometry.net/4100/index-4115.fits \
            http://data.astrometry.net/4100/index-4116.fits \
            http://data.astrometry.net/4100/index-4117.fits \
            http://data.astrometry.net/4100/index-4118.fits \
            http://data.astrometry.net/4100/index-4119.fits "

BB_STRICT_CHECKSUM = "0"

do_install () {
    export INSTALL_DIR="${D}/usr/local/astrometry"
    install -d ${D}/usr/local/astrometry
    oe_runmake install
    install -d ${D}/usr/local/astrometry/data

    install -m 0444 ${WORKDIR}/index-4107.fits ${D}/usr/local/astrometry/data/index-4107.fits
    install -m 0444 ${WORKDIR}/index-4108.fits ${D}/usr/local/astrometry/data/index-4108.fits
    install -m 0444 ${WORKDIR}/index-4109.fits ${D}/usr/local/astrometry/data/index-4109.fits
    install -m 0444 ${WORKDIR}/index-4110.fits ${D}/usr/local/astrometry/data/index-4110.fits
    install -m 0444 ${WORKDIR}/index-4111.fits ${D}/usr/local/astrometry/data/index-4111.fits
    install -m 0444 ${WORKDIR}/index-4112.fits ${D}/usr/local/astrometry/data/index-4112.fits
    install -m 0444 ${WORKDIR}/index-4113.fits ${D}/usr/local/astrometry/data/index-4113.fits
    install -m 0444 ${WORKDIR}/index-4114.fits ${D}/usr/local/astrometry/data/index-4114.fits
    install -m 0444 ${WORKDIR}/index-4115.fits ${D}/usr/local/astrometry/data/index-4115.fits
    install -m 0444 ${WORKDIR}/index-4116.fits ${D}/usr/local/astrometry/data/index-4116.fits
    install -m 0444 ${WORKDIR}/index-4117.fits ${D}/usr/local/astrometry/data/index-4117.fits
    install -m 0444 ${WORKDIR}/index-4118.fits ${D}/usr/local/astrometry/data/index-4118.fits
    install -m 0444 ${WORKDIR}/index-4119.fits ${D}/usr/local/astrometry/data/index-4119.fits

    echo "cpulimit 200" > ${D}/usr/local/astrometry/etc/astrometry.cfg
    echo "add_path /usr/local/astrometry/data" >> ${D}/usr/local/astrometry/etc/astrometry.cfg
    echo "autoindex" >> ${D}/usr/local/astrometry/etc/astrometry.cfg
}

TARGET_CC_ARCH += "${LDFLAGS}"

ERROR_QA:remove = "staticdev"
