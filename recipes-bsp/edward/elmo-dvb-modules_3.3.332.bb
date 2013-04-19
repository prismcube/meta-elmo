DESCRIPTION = "Hardware drivers for ELMO"
LICENSE = "proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

KV = "2.6.37"

PV = "3.3.0"

SRCDATE = "20130408"

PR = "SDK.GA330.${SRCDATE}"

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "http://update.prismcube.com/Ruby/elmo-dualhd-gcc-4.4.2_glibc-linux-debug-${PR}.tar.gz"
SRC_URI += "file://S10_stb_sys_startup.sh \
	    file://S15_stb_dev_node.sh \
	    file://S50_stb_load_app.sh \
	    file://lircd.conf \
	    file://cnxt.service \
	    file://entropic.target \
	    file://cnxt_init \
		"

S = "${WORKDIR}"

do_configure() {
}
do_compile() {
}
do_install() {
        install -d ${D}/opt
	cp ${WORKDIR}/opt/* ${D}/opt/ -av 
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/S*_stb_*.sh ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/cnxt_init ${D}${sysconfdir}/init.d/
	install -d ${D}${sysconfdir}/rcS.d
	touch ${WORKDIR}/opt/.appfs
	install -d ${D}/app/
	install -m 0755 ${WORKDIR}/lircd.conf ${D}${sysconfdir}/
	install -d ${D}/lib
	install -d ${D}/lib/firmware
	cd ${D}/lib/firmware
	ln -sf /opt/lib/firmware/apollo_vfw.bin apollo_vfw.bin
	ln -sf /opt/lib/firmware/tmasAFWFramework.mi tmasAFWFramework.mi
	install -d ${D}/lib/systemd/system/entropic.target.wants
	install -d ${D}/lib/systemd/system/basic.target.wants
	cp ${WORKDIR}/cnxt.service ${D}/lib/systemd/system/
	cp ${WORKDIR}/entropic.target ${D}/lib/systemd/system/
	cd ${D}/lib/systemd/system/entropic.target.wants
	ln -sf /lib/systemd/system/cnxt.service cnxt.service
	cd ${D}/lib/systemd/system/basic.target.wants
	ln -sf /lib/systemd/system/cnxt.service cnxt.service
}
do_package_qa() {
}

#HACK! These are binaries, so we can't guarantee that LDFLAGS match :(
INSANE_SKIP_${PN} = "ldflags dev-so" 

SRC_URI[md5sum] = "11ba2099ff96d045924c73e19926f1f6"
SRC_URI[sha256sum] = "f7a4ea3a3630958687bceca4d30ad00b7a5fbd2136d7aa58dd1ed195e64b31b6"

#PACKAGE_ARCH := "${MACHINE_ARCH}"
PACKAGE := "${PN} ${PN}-dbg "
FILES_${PN} = "/ "
FILES_${PN} += "/opt/.appfs "

